package org.lompo.softwares.updates;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UpdatesController {
	
	@RequestMapping(value = "/updates", method = RequestMethod.GET)
	public String updates(Principal principal) {
		return principal != null ? "updates/updatesSignedIn" : "updates/updatesNotSignedIn";
	}

}
