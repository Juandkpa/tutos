package com.worldmediahd.ui;

import com.tutos.dao.EstudianteDAO;
import com.tutos.dao.MonitorDAO;
import com.tutos.model.Estudiante;
import com.tutos.model.Genero;
import com.tutos.model.Monitor;
import com.vaadin.ui.VerticalLayout;

import java.util.Arrays;

import com.vaadin.data.Item;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.validator.IntegerValidator;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.DateField;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.Form;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Window;
import com.vaadin.ui.Window.Notification;

public class RegistroEstudiante extends VerticalLayout{

		private static final long serialVersionUID = 1L;
		
		private EstudianteDAO estudianteDAO = EstudianteDAO.getInstance();
		private MonitorDAO monitorDAO = MonitorDAO.getInstance(); 
	    // the 'POJO' we're editing.
	    // The Person class is imported from the basic form example.
	    Estudiante estudiante;
	    Monitor monitor;

	    private static final String COMMON_FIELD_WIDTH = "12em";

	    public RegistroEstudiante() {

	        estudiante = new Estudiante(); // a person POJO
	        BeanItem<Estudiante> estudianteItem = new BeanItem<Estudiante>(estudiante); // item from
	        
	        monitor = new Monitor(); // a person POJO
	        BeanItem<Monitor> monitorItem = new BeanItem<Monitor>(monitor); // item from
	        
	        // Create the Form
	        final Form estudianteForm = new FormEstudianteLayout(estudianteItem);
	        final Form monitorForm = new FormMonitorLayout(monitorItem);
	        
	        final ComboBox tipoFormulario = new ComboBox(("Tipo usuario"));
	        
	        final String[] datos = {"Estudiante", "Monitor"};
	        
	        tipoFormulario.addItem(datos[0]);
	        tipoFormulario.addItem(datos[1]);
	        tipoFormulario.select(datos[0]);
	        tipoFormulario.setNullSelectionAllowed(false);
	        tipoFormulario.setTextInputAllowed(false);
	        
	        tipoFormulario.setImmediate(true);
	        tipoFormulario.addListener(new ValueChangeListener() {
				
				private static final long serialVersionUID = 1L;

				@Override
				public void valueChange(ValueChangeEvent event) {
					if(event.getProperty().getValue().equals(datos[0])){
						removeComponent(monitorForm);
						addComponent(estudianteForm);
					}else{
						removeComponent(estudianteForm);
						addComponent(monitorForm);					
					}
					
				}
			});
	       

	        Button aceptar = new Button("Aceptar");
	        aceptar.addListener(new ClickListener() {
				
				private static final long serialVersionUID = 1L;

				@Override
				public void buttonClick(ClickEvent event) {
					Window mainWindow = MyVaadinApplication.getInstance().getMainWindow();
					
					if(tipoFormulario.getValue().equals(datos[0])){
						try{
							estudianteForm.commit();
						}catch(Exception exception){
							mainWindow.showNotification("Datos Invalidos.", Notification.TYPE_ERROR_MESSAGE);
							return;
						}
						
						estudianteDAO.insertEntity(estudiante);
//						mainWindow.removeAllComponents();
						mainWindow.removeWindow(RegistroEstudiante.this.getWindow());
//						mainWindow.addComponent(new Main());
						
					}else{
						try{
							monitorForm.commit();
						}catch(Exception exception){
							mainWindow.showNotification("Datos Invalidos.", Notification.TYPE_ERROR_MESSAGE);
							return;
						}
					
						monitorDAO.insertEntity(monitor);
//						mainWindow.removeAllComponents();
						mainWindow.removeWindow(RegistroEstudiante.this.getWindow());
//						mainWindow.addComponent(new Main());
					}
					
				}
			});
	        
	        // Add form to layout
	        addComponent(tipoFormulario);
	        setComponentAlignment(tipoFormulario, Alignment.TOP_CENTER);
	        addComponent(estudianteForm);
	        setComponentAlignment(estudianteForm, Alignment.BOTTOM_CENTER);
	        
	        addComponent(aceptar);
	        setComponentAlignment(aceptar, Alignment.MIDDLE_CENTER);
	        
	        setWidth("370px");
	        setHeight("-1px");
	        
	        
	    }

	    public class FormMonitorLayout extends Form {

	    	private static final long serialVersionUID = 1L;
	    	
	        private GridLayout ourLayout;

	        public FormMonitorLayout(BeanItem<Monitor> monitorItem) {
	            setCaption("Personal details");

	            // Create our layout (3x3 GridLayout)
	            ourLayout = new GridLayout(2, 5);

	            // Use top-left margin and spacing
	            ourLayout.setMargin(true, false, false, true);
	            ourLayout.setSpacing(true);

	            setLayout(ourLayout);

	            // Set up buffering
	            setWriteThrough(false); // we want explicit 'apply'
	            setInvalidCommitted(false); // no invalid values in datamodel

	            // FieldFactory for customizing the fields and adding validators
	            //setFormFieldFactory(new PersonFieldFactory());
	            setFormFieldFactory(new MonitorFieldFactory());
	            setItemDataSource(monitorItem); // bind to POJO via BeanItem

	            // Determines which properties are shown, and in which order:
	            setVisibleItemProperties(Arrays.asList(new String[] { "nombre",
	                    "edad", "telefono", "correo",
	                    "centroEducativo", "genero", "infoAcademica", "ubicacion", "password"}));

	        }

	        /*
	         * Override to get control over where fields are placed.
	         */
	        @Override
	        protected void attachField(Object propertyId, Field field) {
	            if (propertyId.equals("nombre")) {
	                ourLayout.addComponent(field, 0, 0);
	            } else if (propertyId.equals("edad")) {
	                ourLayout.addComponent(field, 1, 0);
	            } else if (propertyId.equals("telefono")) {
	                ourLayout.addComponent(field, 0, 1);
	            } else if (propertyId.equals("correo")) {
	                ourLayout.addComponent(field, 1, 1);
	            } else if (propertyId.equals("centroEducativo")) {
	                ourLayout.addComponent(field, 0, 2);
	            } else if (propertyId.equals("genero")) {
	                ourLayout.addComponent(field, 1, 2);
	            } else if (propertyId.equals("infoAcademica")) {
	                ourLayout.addComponent(field, 0, 3);
	            } else if (propertyId.equals("ubicacion")) {
	                ourLayout.addComponent(field, 1, 3);
	            }  else if (propertyId.equals("password")) {
	                ourLayout.addComponent(field, 0, 4);
	            }
	        }

	    }

	    public class FormEstudianteLayout extends Form {

	    	private static final long serialVersionUID = 1L;
	    	
	        private GridLayout ourLayout;

	        public FormEstudianteLayout(BeanItem<Estudiante> estudianteItem) {
	            setCaption("Datos personales");

	            // Create our layout (3x3 GridLayout)
	            ourLayout = new GridLayout(2, 4);

	            // Use top-left margin and spacing
	            ourLayout.setMargin(true, false, false, true);
	            ourLayout.setSpacing(true);

	            setLayout(ourLayout);

	            // Set up buffering
	            setWriteThrough(false); // we want explicit 'apply'
	            setInvalidCommitted(false); // no invalid values in datamodel

	            // FieldFactory for customizing the fields and adding validators
	            //setFormFieldFactory(new PersonFieldFactory());
	            setFormFieldFactory(new EstudianteFieldFactory());
	            setItemDataSource(estudianteItem); // bind to POJO via BeanItem

	            // Determines which properties are shown, and in which order:
	            setVisibleItemProperties(Arrays.asList(new String[] { "nombre",
	                    "edad", "telefono", "correo",
	                    "centroEducativo", "genero", "password" }));

	        }

	        /*
	         * Override to get control over where fields are placed.
	         */
	        @Override
	        protected void attachField(Object propertyId, Field field) {
	            if (propertyId.equals("nombre")) {
	                ourLayout.addComponent(field, 0, 0);
	            } else if (propertyId.equals("edad")) {
	                ourLayout.addComponent(field, 1, 0);
	            } else if (propertyId.equals("telefono")) {
	                ourLayout.addComponent(field, 0, 1);
	            } else if (propertyId.equals("correo")) {
	                ourLayout.addComponent(field, 1, 1);
	            } else if (propertyId.equals("centroEducativo")) {
	                ourLayout.addComponent(field, 0, 2);
	            } else if (propertyId.equals("genero")) {
	                ourLayout.addComponent(field, 1, 2);
	            } else if (propertyId.equals("password")) {
	                ourLayout.addComponent(field, 0, 3);
	            }
	        }

	    }
	    
	    
	    private class EstudianteFieldFactory extends DefaultFieldFactory {
	    	
	    	private static final long serialVersionUID = 1L;
			
			public EstudianteFieldFactory() {
	        }

	        @Override
	        public Field createField(Item item, Object propertyId,
	                Component uiContext) {
	            Field f;
	            ComboBox comboBox; 
	            
	            if ("password".equals(propertyId)) {
	                // Create a password field so the password is not shown
	                f = createPasswordField(propertyId);
	            } else {
	                // Use the super class to create a suitable field base on the
	                // property type.
	                f = super.createField(item, propertyId, uiContext);
	            }

	            if ("nombre".equals(propertyId)) {
	                TextField tf = (TextField) f;
	                tf.setRequired(true);
	                tf.setNullRepresentation("");
	                tf.setRequiredError("Por favor ingrese el nombre");
	                tf.setInputPrompt("Nombre completo");
	                tf.setWidth(COMMON_FIELD_WIDTH);
	                tf.addValidator(new StringLengthValidator(
	                        "El nombre debe tener entre 10 y 30 caracteres", 10, 30, false));
	            } else if ("edad".equals(propertyId)) {
	                DateField tf = (DateField) f;
	                tf.setRequired(true);
	                tf.setRequiredError("Escoja su fecha");
	                tf.setWidth(COMMON_FIELD_WIDTH);
	            } else if ("telefono".equals(propertyId)) {
	            	TextField tf = (TextField) f;
	                tf.setRequired(true);
	                tf.setNullRepresentation("");
	                tf.setRequiredError("Por favor ingrese el telefono");
	                tf.setInputPrompt("Teléfono");
	                tf.setWidth(COMMON_FIELD_WIDTH);
	                tf.addValidator(new IntegerValidator(
	                        "El teléfono no debe contener caractéres"));
	            } else if ("correo".equals(propertyId)) {
	                TextField tf = (TextField) f;
	                tf.setRequired(true);
	                tf.setNullRepresentation("");
	                tf.setRequiredError("Por favor ingrese su correo");
	                tf.setInputPrompt("Correo electrónico");
	                tf.setWidth(COMMON_FIELD_WIDTH);
	                tf.addValidator(new StringLengthValidator(
	                        "El correo debe contener entre 6 y 30 caracteres", 6, 30, false));
	                //tf.setWidth("4em");
	            } else if ("centroEducativo".equals(propertyId)) {
	                TextField tf = (TextField) f;
	                tf.setRequired(true);
	                tf.setNullRepresentation("");
	                tf.setRequiredError("Por favor ingrese su centro educativo");
	                tf.setInputPrompt("Centro educativo");
	                tf.setWidth(COMMON_FIELD_WIDTH);
	                tf.addValidator(new StringLengthValidator(
	                        "El centro educativo debe contener entre 5 y 25 caracteres", 3, 25, false));
	                //tf.setWidth("4em");
	            } else if("genero".equals(propertyId)){
	            	comboBox = new ComboBox();
	            	comboBox.setCaption("Género");
	            	comboBox.setPropertyDataSource(item.getItemProperty(propertyId));

	            	BeanItemContainer<Genero> container = new BeanItemContainer<Genero>(Genero.class);
	            	container.addBean(Genero.MASCULINO);
	            	container.addBean(Genero.FEMENINO);
	            	
	            	comboBox.setContainerDataSource(container);
	            	comboBox.setNullSelectionAllowed(false);
	            	comboBox.select(Genero.MASCULINO);
	            	comboBox.setTextInputAllowed(false);
	            	return comboBox;
	            }

	            return f;
	        }
	        
	       

	        private PasswordField createPasswordField(Object propertyId) {
	            PasswordField pf = new PasswordField();
	            pf.setCaption(DefaultFieldFactory
	                    .createCaptionByPropertyId(propertyId));
	            pf.setNullRepresentation("");
	            return pf;
	        }
	    }
	    private class MonitorFieldFactory extends DefaultFieldFactory {
	    	
	    	private static final long serialVersionUID = 1L;
			
	        public MonitorFieldFactory() {
	        }

	        @Override
	        public Field createField(Item item, Object propertyId,
	                Component uiContext) {
	            Field f;
	            ComboBox comboBox; 
	            
	            if ("password".equals(propertyId)) {
	                // Create a password field so the password is not shown
	                f = createPasswordField(propertyId);
	            } else {
	                // Use the super class to create a suitable field base on the
	                // property type.
	                f = super.createField(item, propertyId, uiContext);
	            }

	            if ("nombre".equals(propertyId)) {
	                TextField tf = (TextField) f;
	                tf.setRequired(true);
	                tf.setNullRepresentation("");
	                tf.setRequiredError("Por favor ingrese el nombre");
	                tf.setInputPrompt("Nombre completo");
	                tf.setWidth(COMMON_FIELD_WIDTH);
	                tf.addValidator(new StringLengthValidator(
	                        "El nombre debe tener entre 10 y 30 caracteres", 10, 30, false));
	            } else if ("edad".equals(propertyId)) {
	            	DateField tf = (DateField) f;
	                tf.setRequired(true);
	                tf.setRequiredError("Escoja su fecha");
	                tf.setWidth(COMMON_FIELD_WIDTH);
	            } else if ("telefono".equals(propertyId)) {
	            	TextField tf = (TextField) f;
	                tf.setRequired(true);
	                tf.setNullRepresentation("");
	                tf.setRequiredError("Por favor ingrese el telefono");
	                tf.setInputPrompt("Teléfono");
	                tf.setWidth(COMMON_FIELD_WIDTH);
	                tf.addValidator(new IntegerValidator(
	                        "El teléfono no debe contener caractéres"));
	            } else if ("correo".equals(propertyId)) {
	                TextField tf = (TextField) f;
	                tf.setRequired(true);
	                tf.setNullRepresentation("");
	                tf.setRequiredError("Por favor ingrese su correo");
	                tf.setInputPrompt("Correo electrónico");
	                tf.setWidth(COMMON_FIELD_WIDTH);
	                tf.addValidator(new StringLengthValidator(
	                        "El correo debe contener entre 6 y 30 caracteres", 6, 30, false));
	                //tf.setWidth("4em");
	            } else if ("centroEducativo".equals(propertyId)) {
	                TextField tf = (TextField) f;
	                tf.setRequired(true);
	                tf.setNullRepresentation("");
	                tf.setRequiredError("Por favor ingrese su centro educativo");
	                tf.setInputPrompt("Centro educativo");
	                tf.setWidth(COMMON_FIELD_WIDTH);
	                tf.addValidator(new StringLengthValidator(
	                        "El centro educativo debe contener entre 5 y 25 caracteres", 3, 25, false));
	                //tf.setWidth("4em");
	            } else if("genero".equals(propertyId)){
	            	comboBox = new ComboBox();
	            	comboBox.setCaption("Género");
	            	comboBox.setPropertyDataSource(item.getItemProperty(propertyId));

	            	BeanItemContainer<Genero> container = new BeanItemContainer<Genero>(Genero.class);
	            	container.addBean(Genero.MASCULINO);
	            	container.addBean(Genero.FEMENINO);
	            	
	            	comboBox.setContainerDataSource(container);
	            	comboBox.setNullSelectionAllowed(false);
	            	comboBox.select(Genero.MASCULINO);
	            	comboBox.setTextInputAllowed(false);
	            	return comboBox;
	            } else if ("infoAcademica".equals(propertyId)) {
	                TextField tf = (TextField) f;
	                tf.setRequired(true);
	                tf.setNullRepresentation("");
	                tf.setRequiredError("Por favor ingrese su información académica");
	                tf.setInputPrompt("Información académica");
	                tf.setWidth(COMMON_FIELD_WIDTH);
	                tf.addValidator(new StringLengthValidator(
	                        "La información debe tener entre 5 y 50 caracteres", 5, 50, false));
	            } else if ("ubicacion".equals(propertyId)) {
	                TextField tf = (TextField) f;
	                tf.setRequired(true);
	                tf.setNullRepresentation("");
	                tf.setRequiredError("Por favor ingrese su ubicación actual");
	                tf.setInputPrompt("Ubicación actual");
	                tf.setWidth(COMMON_FIELD_WIDTH);
	                tf.addValidator(new StringLengthValidator(
	                        "La ubicación debe tener entre 3 y 25 caracteres", 3, 25, false));
	            }

	            return f;
	        }
	        
	        private PasswordField createPasswordField(Object propertyId) {
	            PasswordField pf = new PasswordField();
	            pf.setCaption(DefaultFieldFactory
	                    .createCaptionByPropertyId(propertyId));
	            pf.setNullRepresentation("");
	            return pf;
	        }

}

}