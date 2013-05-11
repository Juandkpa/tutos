// Created on Dec 29, 2011 by mo

package com.worldmediahd.security;

import java.util.Set;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.google.common.collect.ImmutableSet;
import com.tutos.dao.EstudianteDAO;
import com.tutos.dao.MonitorDAO;
import com.tutos.model.Estudiante;
import com.tutos.model.Monitor;
public class ShiroBaseRealm extends AuthorizingRealm {
	
//	static Map<String, String> usersTokens = new HashMap<String, String>();
	private EstudianteDAO estudianteDAO = EstudianteDAO.getInstance(); 
	private MonitorDAO monitorDAO = MonitorDAO.getInstance(); 
	
	public ShiroBaseRealm() {
		super();
//		usersTokens.put("admin", "admin");
//		usersTokens.put("user", "user");
//		usersTokens.put("demo", "demo");
	}
	
	@Override
	public boolean supports(AuthenticationToken token) {
		return true;
	}
	/*
	 * (non-Javadoc)
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 * Cuando un usuario se registra, el token contendrá los datos ingresados. El objeto authenticationInfo, es los datos de
	 * usuario almacenados en la base de datos. Shiro compara estos objetos luego.
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;

		String user = upToken.getUsername();
		
		String password = null;
		
		for(Estudiante estudiante: estudianteDAO.getAll()){
			if(estudiante.getCorreo().equals(user)){
				password = estudiante.getPassword();
				break;
			}
		}
		
		for(Monitor monitor: monitorDAO.getAll()){
			if(monitor.getCorreo().equals(user)){
				password = monitor.getPassword();
				break;
			}
		}
		 

		if (password == null) {	
			throw new AccountException("Null usernames are not allowed by this realm.");
		}
		
		if (!password.equals(String.valueOf(upToken.getPassword()))) {	
			throw new AccountException("Password does not match.");
		}
		
		return new SimpleAuthenticationInfo(user, password, this.getName());
	}

	
	/*
	 * (non-Javadoc)
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 * principals contiene el nombre de usuario registrado, el AuthorizationInfo contiene los roles y permisos asociados con el usuario.
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		if (principals == null) {
			throw new AuthorizationException("PrincipalCollection method argument cannot be null.");
		}
		String username = (String) principals.fromRealm(getName()).iterator().next();
		Set<String> roleNames = ImmutableSet.of();
		if (username != null) {
			roleNames = ImmutableSet.of("admin");
		}
		return new SimpleAuthorizationInfo(roleNames);
	}
	
}
