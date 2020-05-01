package com.example.test.util;
import org.springframework.beans.BeanUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
public class UpdateTool {
    /**
     * 将目标源中不为空的字段过滤，将数据库中查出的数据源复制到提交的目标源中
     *
     * @param source 用id从数据库中查出来的数据源
     * @param target 提交的实体，目标源
     */
    public static void copyNullProperties(Object source, Object target) throws Exception{
        BeanUtils.copyProperties(source, target,reflectTest(target));
    }
    private static String[] reflectTest(Object model) throws Exception{
        Field[] field = model.getClass().getDeclaredFields();
        Set<String> noEmptyName = new HashSet<>();
        for (int j = 0; j < field.length; j++) {
            String name = field[j].getName();
            name = name.substring(0, 1).toUpperCase() + name.substring(1);
            String type = field[j].getGenericType().toString();
            if (type.equals("class java.lang.String")) {
                Method m = model.getClass().getMethod("get" + name);
                String value = (String) m.invoke(model);
                if (value != null&&value!="") {
                    noEmptyName.add(field[j].getName());
                }
            }
            if (type.equals("int")) {
                Method m = model.getClass().getMethod("get" + name);
                Integer value = (Integer) m.invoke(model);
                if (value != null&&value!=0) {
                    noEmptyName.add(field[j].getName());
                }
            }
            if (type.equals("class java.sql.Date")) {
                Method m = model.getClass().getMethod("get" + name);
                Date value = (Date) m.invoke(model);
                if (value != null) {
                    noEmptyName.add(field[j].getName());
                }
            }
        }
        String[] result = new String[noEmptyName.size()];
        return noEmptyName.toArray(result);
    }
    public static void copyZeroProperties(Object source, Object target) throws Exception{
        BeanUtils.copyProperties(source, target,reflectTest2(target));
    }
    private static String[] reflectTest2(Object model) throws Exception{
        Field[] field = model.getClass().getDeclaredFields( );
        Set<String> noEmptyName = new HashSet<>();
        for (int j = 0; j < field.length; j++) {
            String name = field[j].getName();
            name = name.substring(0, 1).toUpperCase() + name.substring(1);
            String type = field[j].getGenericType().toString();
            if (type.equals("class java.lang.String")) {
                Method m = model.getClass().getMethod("get" + name);
                String value = (String) m.invoke(model);
                if (value != null&&value!="") {
                    noEmptyName.add(field[j].getName());
                }
            }
            if (type.equals("int")) {
                Method m = model.getClass().getMethod("get" + name);
                Integer value = (Integer) m.invoke(model);
                if (value != null&&value!=-1) {
                    noEmptyName.add(field[j].getName());
                }
            }
            if (type.equals("double")) {
                Method m = model.getClass().getMethod("get" + name);
                Double value = (Double) m.invoke(model);
                if (value != null&&value!=-1.0) {
                    noEmptyName.add(field[j].getName());
                }
            }
            if (type.equals("class java.sql.Date")) {
                Method m = model.getClass().getMethod("get" + name);
                Date value = (Date) m.invoke(model);
                if (value != null) {
                    noEmptyName.add(field[j].getName());
                }
            }
        }
        String[] result = new String[noEmptyName.size()];
        return noEmptyName.toArray(result);
    }
}