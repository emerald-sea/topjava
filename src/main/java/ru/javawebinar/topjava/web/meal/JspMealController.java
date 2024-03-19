package ru.javawebinar.topjava.web.meal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.to.MealTo;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class JspMealController extends AbstractMealController {

    private static final String baseUrl = "/meals";

    public JspMealController(MealService service) {
        super(service);
    }

    @GetMapping(baseUrl)
    public String getAll(Model model) {
        List<MealTo> mealTos = super.getAll();
        model.addAttribute("meals", mealTos);
        return "meals";
    }

    @GetMapping("/create")
    public String create() {
        return "mealForm";
    }

    @GetMapping(baseUrl + "/{id}/update")
    public String showFormForUpdate(Model model, @PathVariable(value = "id") long id) {
        Meal meal = super.get((int) id);
        model.addAttribute("meal", meal);
        return "mealForm";
    }

    @PostMapping(value = baseUrl + "/save")
    public String save(HttpServletRequest request) throws IOException {
        Meal meal = new Meal(
                LocalDateTime.parse(request.getParameter("dateTime")),
                request.getParameter("description"),
                Integer.parseInt(request.getParameter("calories")));

        if (request.getParameter("id").isEmpty()) {
            super.create(meal);
        } else {
            int id = Integer.parseInt(request.getParameter("id"));
            super.update(meal, id);
        }
        return "redirect:" + baseUrl;
    }

    @PostMapping(value = baseUrl + "/{id}/delete")
    public String delete(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        super.delete(id);
        return "redirect:" + baseUrl;
    }
}
