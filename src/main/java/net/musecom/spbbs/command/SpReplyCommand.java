package net.musecom.spbbs.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import net.musecom.spbbs.dao.SpDao;
import net.musecom.spbbs.dto.SpDto;

public class SpReplyCommand implements SpCommand {

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request =(HttpServletRequest) map.get("request");
		String num = request.getParameter("num");
		
		SpDao dao = new SpDao();
		SpDto dto = dao.reply(num);
		
		model.addAttribute("reply", dto);
	}

}
