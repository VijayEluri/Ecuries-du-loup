(function($) {
    $.fn.notifier = function(url, urlRedirect, notification) {
	var hasNew = localStorage.getItem("notifier.hasnew." + url);
	var lastCall = localStorage.getItem("notifier.lastcall." + url);
	var nowDate = new Date();
	var lastCallDate = new Date();
	lastCallDate.setTime(lastCall);

	var diffInMin = (nowDate - lastCallDate) / (1000 * 60);

	if (hasNew === null || (diffInMin >= 5)) {
	    callWebService($(this), url, urlRedirect, notification);
	} else {
	    defineState($(this), hasNew, urlRedirect);
	    programmNext($(this), url, urlRedirect, notification);
	}
    };

    $.fn.requestnotifier = function() {
	if ($.notification.checkNotification()) {
	    if (!$.notification.hasPermition()) {
		$(this).click(function() {
		    $.notification.requestPermition();

		});
	    } else {
		$(this).attr("disabled", "disabled");
	    }
	} else {
	    $(this).attr("disabled", "disabled");
	}
    };

    var callWebService = function(selector, url, redirect, notification) {
	$.ajax({
	    url : url,
	    type : "get",
	    dataType : "json"
	}).done(function(data) {
	    $(".notifier-icon", selector).removeClass("error");
	    var hasNew = false;
	    var dateLastAdding = null;
	    try {
		hasNew = data.forum.hasNew;
	    } catch (e) {
		try {
		    hasNew = data.photo.hasNew;
		} catch (e) {
		}
	    }
	    try {
		dateLastAdding = data.forum.timeLastAction;
	    } catch (e) {
		try {
		    dateLastAdding = data.photo.timeLastAction;
		} catch (e) {
		}
	    }

	    defineState(selector, hasNew, redirect);
	    localStorage.setItem("notifier.hasnew." + url, "" + hasNew);
	    localStorage.setItem("notifier.lastcall." + url, "" + new Date().getTime());

	    var lastNotify = localStorage.getItem("notifier.lastNotify." + url);
	    if (lastNotify != dateLastAdding) {
		$.notification.show(notification.image, notification.title, notification.message);
		localStorage.setItem("notifier.lastNotify." + url, dateLastAdding);

	    }
	}).fail(function() {
	    // if ($(".notifier-icon", selector).length === 0) {
	    // var notifierIcon = document.createElement("div");
	    // $(notifierIcon).addClass("notifier-icon");
	    // selector.prepend(notifierIcon);
	    // }
	    // $(".notifier-icon", selector).addClass("error");
	}).always(function() {
	    programmNext(selector, url, redirect);
	});

    };

    var defineState = function(selector, hasNew, redirect) {
	if (hasNew) {
	    if ($(".notifier-icon", selector).length === 0) {
		var notifierIcon = document.createElement("img");
		$(notifierIcon).attr("src", ctx + "/images/notifier/notRead.png");
		$(notifierIcon).addClass("notifier-icon");
		$(notifierIcon).click(function() {
		    window.location = redirect;
		});
		selector.prepend(notifierIcon);
	    }
	} else {
	    $(".notifier-icon", selector).remove();
	}
    };

    var programmNext = function(selector, url, redirect, notification) {
	setTimeout($.proxy(function() {
	    callWebService(selector, url, redirect, notification);
	}, this), 5 * 60 * 1000);
    };

})(jQuery);

$(document).ready(function() {
    var urlForum = ctx + "/ws/status/forum";
    var urlRedirectForum = ctx + "/forum/affichage.do?nonLu";
    $("#forumNotifier").notifier(urlForum, urlRedirectForum, {
	image : "",
	title : "Nouveau message.",
	message : "Un nouveau message dans le forum."
    });

    var urlMedia = ctx + "/ws/status/photos";
    var urlRedirectMedia = ctx + "/albumPhoto/affichage.do?nonVu";
    $("#mediaNotifier").notifier(urlMedia, urlRedirectMedia, {
	image : "",
	title : "Nouvelle photo.",
	message : "Une nouvelle photo dans l'album photo."
    });

    $(".requestnotifier").requestnotifier();

});