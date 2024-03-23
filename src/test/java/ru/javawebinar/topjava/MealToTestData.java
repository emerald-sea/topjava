package ru.javawebinar.topjava;

import ru.javawebinar.topjava.to.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.List;

import static ru.javawebinar.topjava.MealTestData.*;
import static ru.javawebinar.topjava.util.MealsUtil.*;

public class MealToTestData {
    public static final MatcherFactory.Matcher<MealTo> MEAL_TO_MATCHER = MatcherFactory
            .usingIgnoringFieldsComparator(MealTo.class, "");
    public static final List<MealTo> MEAL_TOS = MealsUtil.getTos(meals, DEFAULT_CALORIES_PER_DAY);
    public static final List<MealTo> MEAL_TOS_BETWEEN = List.of(MEAL_TOS.get(2), MEAL_TOS.get(6));
}
