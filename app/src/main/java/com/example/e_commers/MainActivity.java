package com.example.e_commers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.e_commers.adapter.CategoryAdapter;
import com.example.e_commers.adapter.CourseAdapter;
import com.example.e_commers.model.Category;
import com.example.e_commers.model.Course;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryRecycler, courseRecycler;
    CategoryAdapter categoryAdapter;
    CourseAdapter courseAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "Игры"));
        categoryList.add(new Category(2, "Сайты"));
        categoryList.add(new Category(3, "Языки"));
        categoryList.add(new Category(4, "Прочее"));

        setCategoryRecucler(categoryList);

        List<Course> courseList = new ArrayList<>();
        courseList.add(new Course(1, "java", "Профессия Java\nразработчик", "20 августа", "начальный", "#424345", "java"));
        courseList.add(new Course(2, "python", "Профессия Python\nразработчик", "13 июля", "начальный", "#9FA52D", "python"));
        courseList.add(new Course(3, "cpp", "Профессия C++\nразработчик", "06 июля", "средний", "#21385E", "cpp"));
        courseList.add(new Course(4, "front_end", "Профессия Front end\nразработчик", "06 июля", "средний", "#BEC1C7", "front_end"));
        courseList.add(new Course(5, "unity", "Профессия Unity\nразработчик", "02 сенятбря ", "начальный", "#8E1461", "unity"));
        courseList.add(new Course(6, "full_stack", "Профессия Full stack\nразработчик", "14 сентября", "средний", "#FFBF00", "full_stack"));

        setCourseRecucler(courseList);
    }

    private void setCourseRecucler(List<Course> courselist) {

        RecyclerView.LayoutManager LayoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        courseRecycler = findViewById(R.id.courseRecycler);
        courseRecycler.setLayoutManager(LayoutManager);

        courseAdapter = new CourseAdapter(this, courselist);
        courseRecycler.setAdapter(courseAdapter);

    }

    private void setCategoryRecucler(List<Category> categoryList) {

        RecyclerView.LayoutManager LayoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(LayoutManager);

        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);

    }
}