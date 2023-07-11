package com.example.e_commers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.e_commers.adapter.CategoryAdapter;
import com.example.e_commers.adapter.CourseAdapter;
import com.example.e_commers.model.Category;
import com.example.e_commers.model.Course;
import com.example.e_commers.model.Order;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryRecycler, courseRecycler;
    CategoryAdapter categoryAdapter;
    static CourseAdapter courseAdapter;
    static List<Course> courseList = new ArrayList<>();
    static List<Course> fullCourseList = new ArrayList<>();

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


        courseList.add(new Course(1, "java", "Профессия Java\nразработчик", "20 августа", "начальный", "#424345", "java", 3 ));
        courseList.add(new Course(2, "python", "Профессия Python\nразработчик", "13 июля", "начальный", "#9FA52D", "python", 3));
        courseList.add(new Course(3, "cpp", "Профессия C++\nразработчик", "06 июля", "средний", "#21385E", "cpp", 3));
        courseList.add(new Course(4, "front_end", "Профессия Front end\nразработчик", "06 июля", "средний", "#BEC1C7", "front_end", 2));
        courseList.add(new Course(5, "unity", "Профессия Unity\nразработчик", "02 сенятбря ", "начальный", "#8E1461", "unity", 1));
        courseList.add(new Course(6, "full_stack", "Профессия Full stack\nразработчик", "14 сентября", "средний", "#FFBF00", "full_stack", 2));

        fullCourseList.addAll(courseList);

        setCourseRecucler(courseList);
    }

    public void openShoppingCart(View view){
        Intent intent = new Intent(this, OrderPage.class);
        startActivity(intent);
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

    public static void  showCoursesByCategory(int category){

        courseList.clear();
        courseList.addAll(fullCourseList);

        List<Course> filterCourses = new ArrayList<>();

        for(Course c : courseList){
            if (c.getCategory() == category)
                filterCourses.add(c);
        }
        courseList.clear();
        courseList.addAll(filterCourses);

        courseAdapter.notifyDataSetChanged();
    }
}