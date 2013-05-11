package com.worldmediahd.ui;

import java.io.File;

import com.vaadin.terminal.ExternalResource;
import com.vaadin.terminal.FileResource;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

public class MainPage extends CustomComponent{

	private static final long serialVersionUID = 1L;
	
	private static final String motivationText = "<P ALIGN=CENTER><FONT SIZE=6>Motivation</FONT></P><P ALIGN=CENTER><FONT SIZE=4 STYLE='font-size: 16pt'>Do you remember when you needed help in your studies because you didn’t understand a topic? Maybe you needed help quickly and there wasn’t help in sight. Well, we saw that situation and we thought an application for you.</FONT></P>";
	private static final String descriptionText = "<P ALIGN=CENTER><FONT FACE='Liberation Serif, serif'><FONT SIZE=4 STYLE='font-size: 16pt'><FONT COLOR='#000000'>Description</FONT></FONT></FONT></P><P ALIGN=CENTER><BR><BR></P><P ALIGN=CENTER><FONT FACE='Liberation Serif, serif'><FONT SIZE=4 STYLE='font-size: 16pt'><FONT COLOR='#000000'>Tutos is a web application thought for students from schools or universities who need help in subjects like physics, chemistry, math, programming, etc. The application will allow students to find and contact tutors for their needs. </FONT></FONT></FONT> </P><P ALIGN=CENTER><FONT FACE='Liberation Serif, serif'><FONT SIZE=4 STYLE='font-size: 16pt'>The application is thought as follows: </FONT></FONT> </P><P ALIGN=CENTER><FONT FACE='Liberation Serif, serif'><FONT SIZE=4 STYLE='font-size: 16pt'>Both, students and tutors need to register an account. Once inside, the student can search for a subject in particular, there will be a list of tutors associated to that subject. Tutors must be signed up in the app previously, the student will be able to select a tutor from the list, next, the student will see the information of the tutor, like the topics he teaches, his time availability and the overall score that the community has made about him. Then, the student will be able to contact by message with the tutor for schedule a meeting. </FONT></FONT> </P><P ALIGN=CENTER><BR><BR> </P>"; 
	private static final String desingText="<P ALIGN=CENTER><FONT SIZE=6>Design</FONT></P><P ALIGN=CENTER><FONT SIZE=4 STYLE='font-size: 16pt'>below shows the diagrams of the project.</FONT></P>";
	private static final String technologiesText = "<P ALIGN=CENTER><FONT SIZE=6>Technologies</FONT></P><P ALIGN=CENTER><FONT SIZE=4 STYLE='font-size: 16pt'>below shows the technologies of the project.</FONT></P>";
	private static final String membersText ="<P ALIGN=CENTER ><FONT FACE='Liberation Sans, sans-serif'><FONT SIZE=4 STYLE='font-size: 16pt'><I><B><FONT COLOR='#000000'>Members</FONT></B></I></FONT></FONT></P><P ALIGN=CENTER><FONT FACE='Liberation Sans, sans-serif'><FONT SIZE=4 STYLE='font-size: 16pt'>Daniel Bustos Coral</FONT></FONT></P> <P ALIGN=CENTER><FONT FACE='Liberation Sans, sans-serif'><FONT SIZE=4 STYLE='font-size: 16pt'>Juan Carlos Parra</FONT></FONT></P> <P ALIGN=CENTER><FONT FACE='Liberation Sans, sans-serif'><FONT SIZE=4 STYLE='font-size: 16pt'>Juan Camilo Beltran</FONT></FONT></P> <P ALIGN=CENTER><FONT FACE='Liberation Sans, sans-serif'><FONT SIZE=4 STYLE='font-size: 16pt'>Juan Alejandro Ortiz</FONT></FONT></P><P ALIGN=CENTER><FONT FACE='Liberation Sans, sans-serif'><FONT SIZE=4 STYLE='font-size: 16pt'>Sebastian Gonzalez</FONT></FONT></P> <P ALIGN=CENTER><BR><BR>";
	private static final String titleText = "<P ALIGN=CENTER STYLE='text-decoration: none'><FONT FACE='Liberation Sans, sans-serif'><FONT SIZE=7 STYLE='font-size: 42pt'><I><FONT COLOR='#000000'>TUTOS</FONT></I></FONT></FONT></P><P ALIGN=CENTER><BR><BR></P>";
//	private static final String metodology ;
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
		tabSheet.addTab(description, "Home");
		
		
		Label members = new Label(membersText);
		members.setContentMode(Label.CONTENT_XHTML);
		tabSheet.addTab(members, "Authors");
		
		//desing
		VerticalLayout verticalLayout = new VerticalLayout();
		HorizontalLayout layoutDesing = new HorizontalLayout();		
		
		Label design = new Label(desingText);
		design.setContentMode(Label.CONTENT_XHTML);
		
		ThemeResource UseCase = new ThemeResource("casosdeuso.jpg");
//		ExternalResource UseCase = new ExternalResource("http://imageshack.us/a/img577/2118/casosdeuso.jpg");
		Embedded embeddedUseCase = new Embedded("", UseCase);
		embeddedUseCase.setMimeType("image/jpg");
		embeddedUseCase.setHeight("400px");
		embeddedUseCase.setWidth("300px");
		
		ThemeResource ClassDiagram = new ThemeResource("diagramadeclases1.jpg");
//		ExternalResource ClassDiagram = new ExternalResource("http://img833.imageshack.us/img833/9350/diagramadeclases1.jpg");
		Embedded embeddedClassDiagram = new Embedded("", ClassDiagram);
		embeddedClassDiagram.setMimeType("image/jpg");
		embeddedClassDiagram.setHeight("400px");
		embeddedClassDiagram.setWidth("300px");
		
		ThemeResource SequenceDiagram = new ThemeResource("diagram1y.jpg");
//		ExternalResource SequenceDiagram = new ExternalResource("http://imageshack.us/a/img43/1758/diagram1y.jpg");
		Embedded embeddedSequenceDiagram = new Embedded("", SequenceDiagram);
		embeddedSequenceDiagram.setMimeType("image/jpg");
		embeddedSequenceDiagram.setHeight("400px");
		embeddedSequenceDiagram.setWidth("300px");
		
		
		verticalLayout.addComponent(design);
		verticalLayout.setComponentAlignment(design, Alignment.TOP_CENTER);
		
		layoutDesing.addComponent(embeddedUseCase);
//		layoutDesing.setComponentAlignment(embeddedUseCase, Alignment.TOP_CENTER);
		
		layoutDesing.addComponent(embeddedClassDiagram);
//		layoutDesing.setComponentAlignment(embeddedClassDiagram, Alignment.TOP_CENTER);
		
		layoutDesing.addComponent(embeddedSequenceDiagram);
//		layoutDesing.setComponentAlignment(embeddedSequenceDiagram, Alignment.TOP_CENTER);
		
		layoutDesing.setSpacing(true);
		
		verticalLayout.addComponent(layoutDesing);
		verticalLayout.setComponentAlignment(layoutDesing, Alignment.TOP_CENTER);
		
		tabSheet.addTab(verticalLayout,"Design");
		
		
		
		VerticalLayout layout2 = new VerticalLayout();
		
		Label technologies = new Label(technologiesText);
		technologies.setContentMode(Label.CONTENT_XHTML);
		 
		ThemeResource externalResource = new ThemeResource("tecnologiasfinal.jpg");
//		ExternalResource externalResource = new ExternalResource("http://imageshack.us/a/img832/3672/tecnologiasfinal.jpg");
		Embedded embedded = new Embedded("", externalResource);
		embedded.setMimeType("image/jpg");
		embedded.setWidth("1250px");
		embedded.setHeight("700px");
		
		layout2.addComponent(technologies);
		layout2.setComponentAlignment(technologies, Alignment.TOP_CENTER);
		
		layout2.addComponent(embedded);
		layout2.setComponentAlignment(embedded, Alignment.BOTTOM_CENTER);
		
		tabSheet.addTab(layout2, "Technologies");
		
		
// Metodology
		
		VerticalLayout Meto = new VerticalLayout();
		
		Label metodo = new Label();
		metodo.setContentMode(Label.CONTENT_XHTML);


		
		VerticalLayout sourcesLayout = new VerticalLayout(); 
		
		ExternalResource sourcesLink = new ExternalResource("https://github.com/betoPuentes/tutos/tree/cached");
		Link link = new Link();
		link.setResource(sourcesLink);
		link.setCaption("Github Repository");
		
		ThemeResource imageResource = new ThemeResource("octobiwan.jpg");
//		ExternalResource imageResource = new ExternalResource("https://lh3.googleusercontent.com/-gl3qN0OyUuU/UWFBNTDK-BI/AAAAAAAAEN8/M7WOAKq3Fq0/s1600/octobiwan.jpg");
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
		
		ThemeResource methodologyResource = new ThemeResource("usedmetodology.jpg");
//		ExternalResource methodologyResource = new ExternalResource("http://img585.imageshack.us/img585/4636/usedmetodology.jpg");
		Embedded embeddedMethodology = new Embedded("", methodologyResource);
		embeddedGit.setMimeType("image/jpg");
		embeddedGit.setHeight("400px");
		embeddedGit.setWidth("300px");
		
		tabSheet.addTab(embeddedMethodology,"Methodology");
		
		VerticalLayout layout3 = new VerticalLayout();
		ThemeResource fileResource = new ThemeResource("versioning.pdf");
//		ExternalResource fileResource = new ExternalResource("https://dl.dropboxusercontent.com/u/23734870/versioning.pdf");
		Embedded embeddedVersioning = new Embedded("", fileResource);
//		embeddedVersioning.setMimeType("application/x-pdf");
		embeddedVersioning.setType(Embedded.TYPE_BROWSER);
		embeddedVersioning.setStyleName("full");
		
		tabSheet.addTab(embeddedVersioning,"Versioning");
		
		Button button = new Button("Exit");
		button.addListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				MyVaadinApplication.getInstance().close();
			}
		});
		
		tabSheet.addTab(button,"Exit");
		
		
		return layout;
	}
	
}
