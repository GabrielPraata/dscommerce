package com.prata.dscommerce.tests;

import com.prata.dscommerce.entities.Category;
import org.checkerframework.checker.units.qual.C;

public class CategoryFactory {

    public static Category createCategory() {
        return new Category(1L, "Games");
    }

    public static Category createCategory(Long id, String name) {
        return new Category(id, name);
    }

}
