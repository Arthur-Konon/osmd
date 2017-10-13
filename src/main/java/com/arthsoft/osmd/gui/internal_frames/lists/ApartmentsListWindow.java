package com.arthsoft.osmd.gui.internal_frames.lists;

import com.arthsoft.osmd.annotations.Calculation;
import com.arthsoft.osmd.annotations.Name;
import com.arthsoft.osmd.annotations.Names;
import com.arthsoft.osmd.dao.ApartmentDao;
import com.arthsoft.osmd.dao.PersonDao;
import com.arthsoft.osmd.entity.Apartment;
import com.arthsoft.osmd.entity.Entity;
import com.arthsoft.osmd.entity.Person;
import com.arthsoft.osmd.gui.MainWindow;
import com.arthsoft.osmd.gui.internal_frames.entities.ApartmentWindow;
import com.arthsoft.osmd.util.AppUtils;
import com.arthsoft.osmd.util.GUIUtils;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by arthk on 11.10.2017.
 */
public class ApartmentsListWindow extends EntitiesListWindow {

    public ApartmentsListWindow(String title, String iconPath) {
        super(title, iconPath);
    }

    @Override
    TableModel createModel() {

        Class aClass = Apartment.class;
        Field[] fields = fetchFields(aClass);

        String[] columnNames = fetchNames(fields);

        List<Apartment> apartments = new ApartmentDao().getAll();

        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0){
            @Override
            public Class getColumnClass(int column) {
                return getValueAt(1, column).getClass();
            }
        };

        for (Apartment apartment : apartments) {
            Object[] row = translateEntityToTableRow(apartment, fields);
            tableModel.addRow(row);
        }

        return tableModel;
    }

    private Object[] translateEntityToTableRow(Entity entity, Field[] fields) {
        return Arrays.stream(fields)
                .map(field -> getFieldValue(entity, field))
                .toArray();
    }

    private Object getFieldValue(Object object, Field field) {
        try {
            if (field.isAnnotationPresent(Calculation.class)) {
                return calculateFieldValue(object, field);
            }
            return field.get(object);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Object calculateFieldValue(Object object, Field field) throws Exception {
        String methodName = field.getAnnotation(Calculation.class).methodName();
        Object arg = field.get(object);
        return GUIUtils.class
                .getMethod(methodName, arg.getClass())
                .invoke(null, arg);
    }

    private Field[] fetchFields(Class<Entity> entityClass) {
        Field[] declaredFields = entityClass.getDeclaredFields();
        Field[] entityFields = Entity.class.getDeclaredFields();
        return Stream.concat(Stream.of(entityFields), Stream.of(declaredFields))
                .filter(this::isNamedField)
                .peek(field -> field.setAccessible(true))
                .toArray(Field[]::new);
    }

    private boolean isNamedField(Field field) {
        return field.isAnnotationPresent(Names.class) || field.isAnnotationPresent(Name.class);
    }

    private String[] fetchNames(Field[] fields) {
        List<String> names = new ArrayList<>();
        for (Field field : fields) {
            String name = fetchName(field);
            names.add(name);
        }
        return names.stream().toArray(String[]::new);
    }

    private String fetchName(Field field) {
        return Arrays.stream(field.getAnnotationsByType(Name.class))
                .filter(name -> AppUtils.getLanguage() == name.language())
                .map(Name::name)
                .findFirst()
                .orElse(field.getName());
    }

    void createEntityWindow(String iconPath, int id) {
        MainWindow.getInternalWindowsPane().add(new ApartmentWindow("Квартира редактирование", iconPath));
        System.out.println(id);
    }
}
