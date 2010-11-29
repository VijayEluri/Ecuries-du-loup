package fr.ecuriesduloup.ecurieloup.memo;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mvc.editor.StringDateToLongEditor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.UtilisateurManager;
import donnees.User;
import editor.StringToUserEditor;
import fr.ecuriesduloup.ecurieLoup.memo.data.Memo;
import fr.ecuriesduloup.ecurieLoup.memo.service.MemoManager;

@Controller
public class MemoFormController{
	@Autowired
	@Qualifier("memoManager")
	private MemoManager memoManager;
	@Autowired
	@Qualifier("utilisateurManager")
	private UtilisateurManager utilisateurManager;
	@Autowired
	private StringToUserEditor userEditor;
	@Autowired
	private StringDateToLongEditor stringDateToLongEditor;

	

	public void setStringDateToLongEditor(
			StringDateToLongEditor stringDateToLongEditor) {
		this.stringDateToLongEditor = stringDateToLongEditor;
	}

	public void setMemoManager(MemoManager memoManager) {
		this.memoManager = memoManager;
	}

	public void setUtilisateurManager(UtilisateurManager utilisateurManager) {
		this.utilisateurManager = utilisateurManager;
	}

	public void setUserEditor(StringToUserEditor userEditor) {
		this.userEditor = userEditor;
	}

	@ModelAttribute("memo")
	public Memo formBackingObject(HttpServletRequest request){

		String param = request.getParameter("memo");
		if (param == null)
			return new Memo();

		long id = Long.parseLong(param);
		Memo memo = this.memoManager.getById(id);

		return memo;
	}

	@ModelAttribute("users")
	public List<User> referenceData(HttpServletRequest request) throws Exception {
		return this.utilisateurManager.getAll();
	}

	@InitBinder
	public void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(long.class, "deadLine", stringDateToLongEditor);
		binder.registerCustomEditor(User.class, this.userEditor);
	}

	@RequestMapping(value= "/memo/sendMemo.do", method= RequestMethod.GET)
	public String showForm(){
		return "memo/memoForm";
	}
	
	@RequestMapping(value= "/memo/sendMemo.do", method= RequestMethod.POST)
	public String onSubmit(@ModelAttribute("memo") Memo memo, BindingResult result){

		new MemoValidator().validate(memo, result);
		if(result.hasErrors()){
			return "memo/memoForm";
		}
		if (this.isUpdate(memo)) {

			this.memoManager.update(memo);
		} else {
			User sender = this.utilisateurManager.getUtilisateurCourant();
			memo.setSender(sender);
			memo.setPostedDate(new Date().getTime());
			this.memoManager.add(memo);
		}

		return "redirect:myMemos.do";
	}

	private boolean isUpdate(Memo memo) {
		return memo.getId() != 0;
	}
}
