package com.program.tech.task2.source;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CatalogCreationPageController {
    @GetMapping("catalog/create")
    public String showCreationPage() {
        return "createCatalog";
    }
}
