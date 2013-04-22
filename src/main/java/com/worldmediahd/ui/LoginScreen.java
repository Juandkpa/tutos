package com.worldmediahd.ui;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.LoginForm;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.LoginForm.LoginEvent;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Window.Notification;

public class LoginScreen extends VerticalLayout
{
	private static final long serialVersionUID = 1L;
	private MyVaadinApplication app;


	public LoginScreen(MyVaadinApplication app)
	{
		this.app = app;

		// The application caption is shown in the caption bar of the
		// browser window.
		this.app.getMainWindow().setCaption("Simple Vaadin Shiro example");

		setSizeFull();

		Panel loginPanel = new Panel("Inicio");
		loginPanel.setWidth("340px");

		LoginForm loginForm = new LoginForm();
		loginForm.setPasswordCaption("Password");
		loginForm.setUsernameCaption("Usuario");
		loginForm.setLoginButtonCaption("Entrar");

		loginForm.setHeight("100px");
		loginForm.addListener(new MyLoginListener(this.app, loginForm));
		
		Button crear = new Button("Crear cuenta");
		

		HorizontalLayout organizador = new HorizontalLayout();
		organizador.addComponent(loginForm);
		organizador.addComponent(crear);
		
		RegistroEstudiante crearCuenta = new RegistroEstudiante();
	//	crearCuenta.setWidth("340px");
		
		loginPanel.addComponent(organizador);
		
		
		
		addComponent(loginPanel);
		setComponentAlignment(loginPanel, Alignment.TOP_RIGHT);
		
		final Window ventanaCrearCuenta = new Window("Crear cuenta");
		
		ventanaCrearCuenta.setSizeUndefined();
		ventanaCrearCuenta.addComponent(crearCuenta);
		ventanaCrearCuenta.setWidth("420px");
		ventanaCrearCuenta.setHeight("-1px");
		
		ventanaCrearCuenta.setModal(true);
		ventanaCrearCuenta.setResizable(false);
		
		crear.addListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				getApplication().getMainWindow().addWindow(ventanaCrearCuenta);
				ventanaCrearCuenta.setVisible(true);
			}
		});

//		HorizontalLayout footer = new HorizontalLayout();
//		footer.setHeight("50px");
//		addComponent(footer);
	}

	private static class MyLoginListener implements LoginForm.LoginListener
	{
		private static final long serialVersionUID = 1L;
		private MyVaadinApplication app;
		private LoginForm loginForm;


		public MyLoginListener(MyVaadinApplication app, LoginForm loginForm)
		{
			this.app = app;
			this.loginForm = loginForm;
		}


		@Override
		public void onLogin(LoginEvent event)
		{
			String username = event.getLoginParameter("username");
			String password = event.getLoginParameter("password");

			try
			{
				MyVaadinApplication.getInstance().login(username, password);

				// Switch to the protected view
				app.getMainWindow().setContent(new Main());
			}
			catch (UnknownAccountException uae)
			{
				this.loginForm.getWindow().showNotification("Invalid User", Notification.TYPE_ERROR_MESSAGE);
			}
			catch (IncorrectCredentialsException ice)
			{
				this.loginForm.getWindow().showNotification("Invalid User", Notification.TYPE_ERROR_MESSAGE);
			}
			catch (LockedAccountException lae)
			{
				this.loginForm.getWindow().showNotification("Invalid User", Notification.TYPE_ERROR_MESSAGE);
			}
			catch (ExcessiveAttemptsException eae)
			{
				this.loginForm.getWindow().showNotification("Invalid User", Notification.TYPE_ERROR_MESSAGE);
			}
			catch (AuthenticationException ae)
			{
				this.loginForm.getWindow().showNotification("Invalid User", Notification.TYPE_ERROR_MESSAGE);
			}
			catch (Exception ex)
			{
				this.loginForm.getWindow().showNotification("Exception " + ex.getMessage(), Notification.TYPE_ERROR_MESSAGE);
			}
		}
	}
}
