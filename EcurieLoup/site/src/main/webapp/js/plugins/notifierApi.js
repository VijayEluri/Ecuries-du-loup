/**
 * Demo for HTML5 Notification API
 * 
 * @author Paul
 */
(function($) {

    $.notification = {
	checkNotification : function() {
	    if (window.webkitNotifications) {
		return true;
	    } else {
		return false;
	    }
	},
	show : function(image, title, content) {
	    if (this.checkNotification()) {
		if (window.webkitNotifications.checkPermission() == 0) {
		    notification = null;
		    try {
			var notification = window.webkitNotifications.createNotification(image, title, content);
			notification.show();
			return notification;
		    } catch (e) {
		    }
		}
	    }
	    return null;
	},
	requestPermition : function() {
	    if (this.checkNotification()) {
		if (window.webkitNotifications.checkPermission() != 0) {
		    window.webkitNotifications.requestPermission(function() {
			if (window.webkitNotifications.checkPermission() == 0) {
			    $.notification.show("", "Permission ajouté", "Les permissions de notification pour ce site ont bien été ajouté");
			}

		    });
		}
	    }
	},

	hasPermition : function() {
	    if (this.checkNotification()) {
		if (window.webkitNotifications.checkPermission() === 0) {
		    return true;

		} else {
		    return false;
		}
	    } else {
		return false;
	    }

	}
    };

    /**
     * Init document
     */
    function init_document() {
	// Check browser support
	if (check_browser_support()) {
	    $("h3").click(request_permission);

	    var notification = plain_text_notification($("#icon").val(), $("#title").val(), $("#text").val());
	    notification.show();
	}

    }

    $(document).ready(function() {
	$("h3").click(function() {
	    $.notification.show("truc", "nouveau truc", "un nouveeau truc vous attend");
	});
    });

})(jQuery);