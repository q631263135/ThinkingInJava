package 注解.生成外部文件;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ycz on 2017/12/5 0005.
 */
public class TableCreator {
    public static void main(String[] args) throws ClassNotFoundException {


        if (args.length < 1) {
            System.out.println("arguments: annotated classes");
            System.exit(0);
        }

        for(String className : args) {
            Class<?> clazz = Class.forName(className);
            DBTable dbTableAnno = clazz.getAnnotation(DBTable.class);
            if (dbTableAnno == null) {
                System.out.println("No DBTable annotations in class " + className);
                continue;
            }
            String tableName = dbTableAnno.name();
            if (tableName.length() < 1) {
                tableName = clazz.getName().toUpperCase();
            }
            List<String> columnDefs = new ArrayList<String>();
            for (Field field : clazz.getDeclaredFields()) {

                String columnName = null;
                Annotation[] fieldAnnotations = field.getAnnotations();
                if (fieldAnnotations.length < 1) {
                    continue;
                }
                if (fieldAnnotations[0] instanceof SQLInteger) {
                    SQLInteger sqlInteger = (SQLInteger) fieldAnnotations[0];
                    if (sqlInteger.name().length() < 1) {
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sqlInteger.name().toUpperCase();
                    }
                    columnDefs.add(columnName + " INT" + getConstraints(sqlInteger.constraints()));
                }
            }

            StringBuilder createCommand = new StringBuilder(" CREATE TABLE " + tableName + "(");
            for (String columnDef : columnDefs) {
                createCommand.append("\n " + columnDef + ",");
            }
            String createTableSql = createCommand.substring(0, createCommand.length() - 1) + ");";
            System.out.println("Table Creation SQL for " + className + "is: \n" + createTableSql);
        }


    }

    private static String getConstraints(Constraints c) {
        String constraints = "";
        if (!c.allowNull()) {
            constraints += " NOT NULL";
        }
        if (c.primaryKey()) {
            constraints += " PRIMARY KEY";
        }
        if (c.unique()) {
            constraints += " UNIQUE";
        }
        return constraints;
    }
}
