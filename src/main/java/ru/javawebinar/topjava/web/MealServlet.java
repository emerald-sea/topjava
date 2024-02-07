package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;
import java.util.List;
import java.util.function.Predicate;

import static org.slf4j.LoggerFactory.getLogger;
import static ru.javawebinar.topjava.util.MealsUtil.*;


public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(MealServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("redirect to meals");
        Predicate<Meal> predicate = (meal) -> !meal.getTime().isBefore(LocalTime.of(0, 0));
        List<MealTo> mealsTo = filteredByStreams(meals, predicate, CALORIES_PER_DAY);
        request.setAttribute("meals", mealsTo);
        request.getRequestDispatcher("meals.jsp").forward(request, response);
    }
}
