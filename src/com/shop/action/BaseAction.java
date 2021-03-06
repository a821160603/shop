package com.shop.action;

import com.opensymphony.xwork2.ActionSupport;
import com.shop.dao.order.OrderDao;
import com.shop.dao.product.ProductCategoryDao;
import com.shop.dao.product.ProductDao;
import com.shop.dao.product.UploadFileDao;
import com.shop.dao.user.CustomerDao;
import com.shop.dao.user.UserDao;
import com.shop.model.order.Orderitem;
import com.shop.model.user.Customer;
import com.shop.model.user.User;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author chenchen
 * @date 2018/10/25 14:51
 * @Content:
 */
public class BaseAction extends ActionSupport implements RequestAware, SessionAware, ApplicationAware {
    private static final long serialVersionUID = 1L;
    protected Integer id;
    protected Integer[] ids;
    protected int pageNo = 1;
    protected int pageSize = 3;

    public static final String LIST = "list";
    public static final String EDIT = "edit";
    public static final String ADD = "add";
    public static final String SELECT = "select";
    public static final String QUERY = "query";
    public static final String LEFT = "left";
    public static final String RIGHT = "right";
    public static final String INDEX = "index";
    public static final String MAIN = "main";
    public static final String MANAGER = "manager";
    public static final String TOP = "top";
    public static final String REG = "reg";
    public static final String USER_LOGIN = "userLogin";
    public static final String CUSTOMER_LOGIN = "customerLogin";
    public static final String LOGOUT = "logout";

    // 获取用户id
    // 获取用户对象
    public Customer getLoginCustomer(){
        if(session.get("customer") != null){
            return (Customer) session.get("customer");
        }
        return null;
    }
    // 获取管理员id
    // 获取管理员对象
    public User getLoginUser(){
        if(session.get("admin") != null){
            return (User) session.get("admin");
        }
        return null;
    }

    // 从session中取出购物车
    @SuppressWarnings("unchecked")
    protected Set<Orderitem> getCart(){
        Object obj = session.get("cart");
        if(obj == null){
            return new HashSet<Orderitem>();
        }else{
            return (Set<Orderitem>) obj;
        }
    }
    // 注入Dao
    @Autowired
    protected ProductCategoryDao categoryDao;
    @Autowired
    protected ProductDao productDao;
    @Autowired
    protected OrderDao orderDao;
    @Autowired
    protected UserDao userDao;
    @Autowired
    protected CustomerDao customerDao;
    @Autowired

    protected UploadFileDao uploadFileDao;
    // Map类型的request
    protected Map<String, Object> request;
    // Map类型的session
    protected Map<String, Object> session;
    // Map类型的application
    protected Map<String, Object> application;

    @Override
    public void setApplication(Map<String, Object> application) {
        this.application = application;
    }

    @Override
    public void setRequest(Map <String, Object> request) {
        this.request = request;
    }

    @Override
    public void setSession(Map <String, Object> session) {
        this.session = session;
    }
    // 处理方法
    public String index() throws Exception {
        return INDEX;
    }
    public String manager() throws Exception {
        return MANAGER;
    }
    public String main() throws Exception {
        return MAIN;
    }
    public String add() throws Exception {
        return ADD;
    }
    public String select() throws Exception {
        return SELECT;
    }
    public String execute() throws Exception {
        return SUCCESS;
    }
    public String top() throws Exception {
        return TOP;
    }
    public String left() throws Exception {
        return LEFT;
    }
    public String right() throws Exception {
        return RIGHT;
    }
    public String reg() throws Exception{
        return REG;
    }
    public String query() throws Exception{
        return QUERY;
    }
    // getter和settter方法
    public Integer[] getIds() {
        return ids;
    }
    public void setIds(Integer[] ids) {
        this.ids = ids;
    }
    public int getPageNo() {
        return pageNo;
    }
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}
