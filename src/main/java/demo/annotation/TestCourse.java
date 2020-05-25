package demo.annotation;

@CourseInfoAnnotation(courseName = "自研框架", courseTag = "spring",
        courseProfile = "不仅讲解Java相关的核心知识，还涉及网络、数据库、缓存框架等核心知识，"
                + "构建海陆空一体化的面试护城河。"
                + "全面提升内功。"
)
public class TestCourse {
    @PersonInfoAnnotation(name = "spring", language = {"Java","C++","Go","Python","PHP","JS"})
    private String author;
    @CourseInfoAnnotation(courseName = "校园商铺",
            courseTag = "实战",
            courseProfile = "手把手教会从前端到后端开发多店铺商铺管理系统，"
                    + "可以用在毕设创业中，学习完会对SSM以及Springboot有一个"
                    + "全面的了解",
            courseIndex = 144)
    public void getCourseInfo() {

    }
}
