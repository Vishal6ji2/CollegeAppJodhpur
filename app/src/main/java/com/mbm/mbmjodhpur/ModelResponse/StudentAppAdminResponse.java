package com.mbm.mbmjodhpur.ModelResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class StudentAppAdminResponse implements Serializable
{

    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("message")
    @Expose
    private String message;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public static class Data implements Serializable
    {

        @SerializedName("admin")
        @Expose
        private ArrayList<Admin> admin = null;
        @SerializedName("news")
        @Expose
        private ArrayList<News> news = null;
        @SerializedName("placement")
        @Expose
        private ArrayList<Placement> placement = null;
        @SerializedName("noticeboard")
        @Expose
        private ArrayList<Noticeboard> noticeboard = null;
        @SerializedName("library")
        @Expose
        private ArrayList<Library> library = null;
        @SerializedName("timetable")
        @Expose
        private ArrayList<Timetable> timetable = null;
        @SerializedName("syllabus")
        @Expose
        private ArrayList<Syllabus> syllabus = null;
        @SerializedName("link")
        @Expose
        private ArrayList<Link> link = null;
        @SerializedName("subject")
        @Expose
        private ArrayList<Subject> subject = null;

        public ArrayList<Admin> getAdmin() {
            return admin;
        }

        public void setAdmin(ArrayList<Admin> admin) {
            this.admin = admin;
        }

        public ArrayList<News> getNews() {
            return news;
        }

        public void setNews(ArrayList<News> news) {
            this.news = news;
        }

        public ArrayList<Placement> getPlacement() {
            return placement;
        }

        public void setPlacement(ArrayList<Placement> placement) {
            this.placement = placement;
        }

        public ArrayList<Noticeboard> getNoticeboard() {
            return noticeboard;
        }

        public void setNoticeboard(ArrayList<Noticeboard> noticeboard) {
            this.noticeboard = noticeboard;
        }

        public ArrayList<Library> getLibrary() {
            return library;
        }

        public void setLibrary(ArrayList<Library> library) {
            this.library = library;
        }

        public ArrayList<Timetable> getTimetable() {
            return timetable;
        }

        public void setTimetable(ArrayList<Timetable> timetable) {
            this.timetable = timetable;
        }

        public ArrayList<Syllabus> getSyllabus() {
            return syllabus;
        }

        public void setSyllabus(ArrayList<Syllabus> syllabus) {
            this.syllabus = syllabus;
        }

        public ArrayList<Link> getLink() {
            return link;
        }

        public void setLink(ArrayList<Link> link) {
            this.link = link;
        }

        public ArrayList<Subject> getSubject() {
            return subject;
        }

        public void setSubject(ArrayList<Subject> subject) {
            this.subject = subject;
        }


        public static class Admin implements Serializable
        {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("dept_id")
            @Expose
            private String deptId;
            @SerializedName("image_url")
            @Expose
            private Object imageUrl;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("email")
            @Expose
            private String email;
            @SerializedName("mobile")
            @Expose
            private String mobile;
            @SerializedName("status")
            @Expose
            private String status;
            @SerializedName("super_admin")
            @Expose
            private String superAdmin;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getDeptId() {
                return deptId;
            }

            public void setDeptId(String deptId) {
                this.deptId = deptId;
            }

            public Object getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(Object imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getSuperAdmin() {
                return superAdmin;
            }

            public void setSuperAdmin(String superAdmin) {
                this.superAdmin = superAdmin;
            }

        }
        public static class Library implements Serializable
        {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("dept_id")
            @Expose
            private String deptId;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("author_name")
            @Expose
            private String authorName;
            @SerializedName("edition")
            @Expose
            private String edition;
            @SerializedName("file_name")
            @Expose
            private String fileName;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getDeptId() {
                return deptId;
            }

            public void setDeptId(String deptId) {
                this.deptId = deptId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getAuthorName() {
                return authorName;
            }

            public void setAuthorName(String authorName) {
                this.authorName = authorName;
            }

            public String getEdition() {
                return edition;
            }

            public void setEdition(String edition) {
                this.edition = edition;
            }

            public String getFileName() {
                return fileName;
            }

            public void setFileName(String fileName) {
                this.fileName = fileName;
            }

        }
        public static class Link implements Serializable
        {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("url")
            @Expose
            private String url;
            @SerializedName("admin_id")
            @Expose
            private String adminId;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getAdminId() {
                return adminId;
            }

            public void setAdminId(String adminId) {
                this.adminId = adminId;
            }

        }
        public static class News implements Serializable
        {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("admin_id")
            @Expose
            private String adminId;
            @SerializedName("dept_id")
            @Expose
            private String deptId;
            @SerializedName("file_name")
            @Expose
            private String fileName;
            @SerializedName("created_datetime")
            @Expose
            private String createdDatetime;
            @SerializedName("title")
            @Expose
            private String title;
            @SerializedName("description")
            @Expose
            private String description;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getAdminId() {
                return adminId;
            }

            public void setAdminId(String adminId) {
                this.adminId = adminId;
            }

            public String getDeptId() {
                return deptId;
            }

            public void setDeptId(String deptId) {
                this.deptId = deptId;
            }

            public String getFileName() {
                return fileName;
            }

            public void setFileName(String fileName) {
                this.fileName = fileName;
            }

            public String getCreatedDatetime() {
                return createdDatetime;
            }

            public void setCreatedDatetime(String createdDatetime) {
                this.createdDatetime = createdDatetime;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

        }
        public static class Noticeboard implements Serializable
        {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("dept_id")
            @Expose
            private String deptId;
            @SerializedName("file_name")
            @Expose
            private String fileName;
            @SerializedName("created_datetime")
            @Expose
            private String createdDatetime;
            @SerializedName("title")
            @Expose
            private String title;
            @SerializedName("description")
            @Expose
            private String description;
            @SerializedName("admin_id")
            @Expose
            private String adminId;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getDeptId() {
                return deptId;
            }

            public void setDeptId(String deptId) {
                this.deptId = deptId;
            }

            public String getFileName() {
                return fileName;
            }

            public void setFileName(String fileName) {
                this.fileName = fileName;
            }

            public String getCreatedDatetime() {
                return createdDatetime;
            }

            public void setCreatedDatetime(String createdDatetime) {
                this.createdDatetime = createdDatetime;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getAdminId() {
                return adminId;
            }

            public void setAdminId(String adminId) {
                this.adminId = adminId;
            }

        }
        public static class Placement implements Serializable
        {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("dept_id")
            @Expose
            private String deptId;
            @SerializedName("upload_by")
            @Expose
            private String uploadBy;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("url")
            @Expose
            private String url;
            @SerializedName("file_name")
            @Expose
            private String fileName;
            @SerializedName("title")
            @Expose
            private String title;
            @SerializedName("news")
            @Expose
            private String news;
            @SerializedName("date")
            @Expose
            private String date;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getDeptId() {
                return deptId;
            }

            public void setDeptId(String deptId) {
                this.deptId = deptId;
            }

            public String getUploadBy() {
                return uploadBy;
            }

            public void setUploadBy(String uploadBy) {
                this.uploadBy = uploadBy;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getFileName() {
                return fileName;
            }

            public void setFileName(String fileName) {
                this.fileName = fileName;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getNews() {
                return news;
            }

            public void setNews(String news) {
                this.news = news;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

        }
        public static class Subject implements Serializable
        {

            @SerializedName("department_id")
            @Expose
            private String departmentId;
            @SerializedName("department_name")
            @Expose
            private String departmentName;
            @SerializedName("subject")
            @Expose
            private ArrayList<Subject__1> subject = null;

            public String getDepartmentId() {
                return departmentId;
            }

            public void setDepartmentId(String departmentId) {
                this.departmentId = departmentId;
            }

            public String getDepartmentName() {
                return departmentName;
            }

            public void setDepartmentName(String departmentName) {
                this.departmentName = departmentName;
            }

            public ArrayList<Subject__1> getSubject() {
                return subject;
            }

            public void setSubject(ArrayList<Subject__1> subject) {
                this.subject = subject;
            }

        }
        public static class Subject__1 implements Serializable
        {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("name")
            @Expose
            private String name;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

        }
        public static class Syllabus implements Serializable
        {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("department_id")
            @Expose
            private String departmentId;
            @SerializedName("file_name")
            @Expose
            private String fileName;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDepartmentId() {
                return departmentId;
            }

            public void setDepartmentId(String departmentId) {
                this.departmentId = departmentId;
            }

            public String getFileName() {
                return fileName;
            }

            public void setFileName(String fileName) {
                this.fileName = fileName;
            }

        }
        public static class Timetable implements Serializable
        {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("dept_id")
            @Expose
            private String deptId;
            @SerializedName("file_name")
            @Expose
            private String fileName;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getDeptId() {
                return deptId;
            }

            public void setDeptId(String deptId) {
                this.deptId = deptId;
            }

            public String getFileName() {
                return fileName;
            }

            public void setFileName(String fileName) {
                this.fileName = fileName;
            }

        }
    }
}


