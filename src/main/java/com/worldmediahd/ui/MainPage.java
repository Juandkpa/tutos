package com.worldmediahd.ui;

import com.vaadin.terminal.ExternalResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;

public class MainPage extends CustomComponent{

	private static final long serialVersionUID = 1L;
	
	private static final String motivationText = "<P ALIGN=CENTER><FONT SIZE=6>Motivation</FONT></P><P ALIGN=CENTER><FONT SIZE=4 STYLE='font-size: 16pt'>Do you remember when you needed help in your studies because you didn’t understand a topic? Maybe you needed help quickly and there wasn’t help in sight. Well, we saw that situation and we thought an application for you.</FONT></P>";
	private static final String descriptionText = "<P ALIGN=CENTER><FONT FACE='Liberation Serif, serif'><FONT SIZE=4 STYLE='font-size: 16pt'><FONT COLOR='#000000'>Description</FONT></FONT></FONT></P><P ALIGN=CENTER><BR><BR></P><P ALIGN=CENTER><FONT FACE='Liberation Serif, serif'><FONT SIZE=4 STYLE='font-size: 16pt'><FONT COLOR='#000000'>Tutos is a web application thought for students from schools or universities who need help in subjects like physics, chemistry, math, programming, etc. The application will allow students to find and contact tutors for their needs. </FONT></FONT></FONT> </P><P ALIGN=CENTER><FONT FACE='Liberation Serif, serif'><FONT SIZE=4 STYLE='font-size: 16pt'>The application is thought as follows: </FONT></FONT> </P><P ALIGN=CENTER><FONT FACE='Liberation Serif, serif'><FONT SIZE=4 STYLE='font-size: 16pt'>Both, students and tutors need to register an account. Once inside, the student can search for a subject in particular, there will be a list of tutors associated to that subject. Tutors must be signed up in the app previously, the student will be able to select a tutor from the list, next, the student will see the information of the tutor, like the topics he teaches, his time availability and the overall score that the community has made about him. Then, the student will be able to contact by message with the tutor for schedule a meeting. </FONT></FONT> </P><P ALIGN=CENTER><BR><BR> </P>"; 
	private static final String technologiesText = "<P ALIGN=CENTER><FONT FACE='Liberation Serif, serif'><FONT SIZE=6><FONT COLOR='#000000'>Technologies</FONT></FONT></FONT></P><P ALIGN=CENTER><FONT FACE='Liberation Serif, serif'><FONT SIZE=4 STYLE='font-size: 16pt'><FONT COLOR='#000000'>Dependencies:</FONT></FONT></FONT>	</P><P ALIGN=CENTER><FONT FACE='Liberation Serif, serif'><FONT SIZE=4 STYLE='font-size: 16pt'><FONT COLOR='#000000'>Vaadin	as a rich UI framework.</FONT></FONT></FONT></P><P ALIGN=CENTER><FONT FACE='Liberation Serif, serif'><FONT SIZE=4 STYLE='font-size: 16pt'><FONT COLOR='#000000'>App engine as a web container and datastore. The persistence uses the BigTable's JPA implementation.</FONT></FONT></FONT></P><P ALIGN=CENTER><BR><BR></P><P ALIGN=CENTER><FONT FACE='Liberation Serif, serif'><FONT SIZE=4 STYLE='font-size: 16pt'><FONT COLOR='#000000'>Tools</FONT></FONT></FONT></P>	<P ALIGN=CENTER><FONT FACE='Liberation Serif, serif'><FONT SIZE=4 STYLE='font-size: 16pt'><FONT COLOR='#000000'>Eclipes IDE and App engine plugin.</FONT></FONT></FONT></P> ";
	private static final String membersText ="<P ALIGN=CENTER ><FONT FACE='Liberation Sans, sans-serif'><FONT SIZE=4 STYLE='font-size: 16pt'><I><B><FONT COLOR='#000000'>Members</FONT></B></I></FONT></FONT></P><P ALIGN=CENTER><FONT FACE='Liberation Sans, sans-serif'><FONT SIZE=4 STYLE='font-size: 16pt'>Daniel Bustos Coral</FONT></FONT></P> <P ALIGN=CENTER><FONT FACE='Liberation Sans, sans-serif'><FONT SIZE=4 STYLE='font-size: 16pt'>Juan Carlos Parra</FONT></FONT></P> <P ALIGN=CENTER><FONT FACE='Liberation Sans, sans-serif'><FONT SIZE=4 STYLE='font-size: 16pt'>Juan Camilo Beltran</FONT></FONT></P> <P ALIGN=CENTER><FONT FACE='Liberation Sans, sans-serif'><FONT SIZE=4 STYLE='font-size: 16pt'>Juan Alejandro Ortiz</FONT></FONT></P><P ALIGN=CENTER><FONT FACE='Liberation Sans, sans-serif'><FONT SIZE=4 STYLE='font-size: 16pt'>Sebastian Gonzalez</FONT></FONT></P> <P ALIGN=CENTER><BR><BR>";
	private static final String titleText = "<P ALIGN=CENTER STYLE='text-decoration: none'><FONT FACE='Liberation Sans, sans-serif'><FONT SIZE=7 STYLE='font-size: 42pt'><I><FONT COLOR='#000000'>TUTOS</FONT></I></FONT></FONT></P><P ALIGN=CENTER><BR><BR></P>";
//	private static final String sourceText = "<P ALIGN=CENTER STYLE='margin-bottom: 0cm'><FONT FACE='Liberation Sans, sans-serif'><FONT SIZE=5 STYLE='font-size: 20pt'>SOURCES</FONT></FONT></P><P ALIGN=CENTER STYLE='margin-bottom: 0cm'><BR></P><P ALIGN=CENTER STYLE='margin-bottom: 0cm'><BR></P><P ALIGN=CENTER STYLE='margin-bottom: 0cm'>The link below is the sources repository.</P>";
//	private static final String sourceText = "<p align='CENTER' style='margin-bottom: 0cm'><font face='Liberation Serif, serif'><font size='5' style='font-size: 20pt'>SOURCES</font></font></p><p align='CENTER' style='margin-bottom: 0cm'>&nbsp;</p><p align='CENTER' style='margin-bottom: 0cm'>	&nbsp;</p><p align='CENTER' style='margin-bottom: 0cm'>	The link below is the sources repository.</p>";
//	private static final String sourceText = "<P ALIGN=CENTER><FONT FACE='Liberation Serif, serif'><FONT SIZE=4 STYLE='font-size: 16pt'><FONT COLOR='#000000'>Sources</FONT></FONT></FONT></P><P ALIGN=CENTER><BR><BR></P><P ALIGN=CENTER><FONT FACE='Liberation Serif, serif'><FONT SIZE=4 STYLE='font-size: 16pt'>The link below is the sources repository.</FONT></FONT> </P><P ALIGN=CENTER><BR><BR> </P>";
	
	public MainPage(){
		setCompositionRoot(buildMainLayout());
	}
	
	VerticalLayout buildMainLayout(){
		
		final VerticalLayout layout = new VerticalLayout();
		
		Label title = new Label(titleText);
		title.setContentMode(Label.CONTENT_XHTML);
		
		layout.addComponent(title);
		
		TabSheet tabSheet = new TabSheet();
		tabSheet.setSizeFull();
		
		Label motivation = new Label(motivationText);
		motivation.setContentMode(Label.CONTENT_XHTML);
		VerticalLayout l1 = new VerticalLayout();
		l1.addComponent(motivation);
		tabSheet.addTab(l1, "Motivation");
		
		Label description = new Label(descriptionText);
		description.setContentMode(Label.CONTENT_XHTML);
		tabSheet.addTab(description, "Description");
		
		VerticalLayout layout2 = new VerticalLayout();
		
		Label technologies = new Label(technologiesText);
		technologies.setContentMode(Label.CONTENT_XHTML);
		
		ExternalResource externalResource = new ExternalResource("http://img32.imageshack.us/img32/8451/tecnologias.jpg");
		Embedded embedded = new Embedded("", externalResource);
		embedded.setMimeType("image/jpg");
		
		layout2.addComponent(technologies);
		layout2.setComponentAlignment(technologies, Alignment.TOP_CENTER);
		
		layout2.addComponent(embedded);
		layout2.setComponentAlignment(embedded, Alignment.BOTTOM_CENTER);
		
		tabSheet.addTab(layout2, "Technologies");
		
		Label members = new Label(membersText);
		members.setContentMode(Label.CONTENT_XHTML);
		tabSheet.addTab(members, "Members");
		
		VerticalLayout sourcesLayout = new VerticalLayout(); 
		
		ExternalResource sourcesLink = new ExternalResource("https://github.com/betoPuentes/tutos/tree/cached");
		Link link = new Link();
		link.setResource(sourcesLink);
		link.setCaption("Github Repository");
		
		ExternalResource imageResource = new ExternalResource("https://lh3.googleusercontent.com/-gl3qN0OyUuU/UWFBNTDK-BI/AAAAAAAAEN8/M7WOAKq3Fq0/s1600/octobiwan.jpg");
		Embedded embeddedGit = new Embedded("", imageResource);
		embeddedGit.setMimeType("image/jpg");
		embeddedGit.setHeight("400px");
		embeddedGit.setWidth("300px");
		
//		Label source = new Label(sourceText);
//		members.setContentMode(Label.CONTENT_XHTML);
		
		sourcesLayout.addComponent(embeddedGit);
		sourcesLayout.setComponentAlignment(embeddedGit, Alignment.TOP_CENTER);
		
		sourcesLayout.addComponent(link);
		sourcesLayout.setComponentAlignment(link, Alignment.BOTTOM_CENTER);
		
		tabSheet.addTab(sourcesLayout, "Sources");
		
		
		layout.addComponent(tabSheet);
		layout.setComponentAlignment(tabSheet, Alignment.BOTTOM_CENTER);
		layout.setSizeFull();
		
		return layout;
	}
	
}
