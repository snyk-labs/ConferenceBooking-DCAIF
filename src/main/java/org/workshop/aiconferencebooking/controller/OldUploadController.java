package org.workshop.aiconferencebooking.controller;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.workshop.aiconferencebooking.service.PersonService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Principal;

public class OldUploadController {

    private PersonService personService;

    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";


    public String uploadImage(Model model, MultipartFile file, Principal principal) throws IOException {
        var name = file.getOriginalFilename().replace(" ", "_");
        var fileNameAndPath = Paths.get(UPLOAD_DIRECTORY + File.separator + name);

        var normalizedPath = fileNameAndPath.normalize();
        if (!normalizedPath.startsWith(Paths.get(UPLOAD_DIRECTORY).normalize())) {
            model.addAttribute("message", "ERROR");
            return "person/upload";
        }

        Files.write(normalizedPath, file.getBytes());
        model.addAttribute("msg", "Uploaded images: " + name);

        if (principal == null) {
            model.addAttribute("message", "ERROR");
            return "person/upload";
        }

        var user = principal.getName();
        var person = personService.findByUsername(user);

        person.setProfilePic(name);
        personService.savePerson(person);
        return "person/upload";
    }
}