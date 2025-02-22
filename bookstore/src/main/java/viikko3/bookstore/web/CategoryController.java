package viikko3.bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import viikko3.bookstore.domain.CategoryRepository;
import viikko3.bookstore.domain.Category;

@Controller
public class CategoryController {
    @Autowired

    private CategoryRepository crepository;

    @GetMapping("/categorylist")
    public String getCategories(Model model) {

        List<Category> categories = (List<Category>) crepository.findAll();
        model.addAttribute("categories", categories);

        return "categorylist";
    }

    @GetMapping("/addcategory")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());

        return "addcategory";
    }

    @PostMapping("/savecategory")
    public String saveCategory(Category category) {
        crepository.save(category);

        return "redirect:/categorylist";
    }
}
