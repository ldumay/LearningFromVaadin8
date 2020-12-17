package org.vaadin8.demo;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.UserError;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateTimeField;
import com.vaadin.ui.Label;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import java.util.Optional;
import java.util.Set;
import java.time.LocalDateTime;
import lib.ldumay.DateFormat;
import lib.ldumay.GenerateBirthday;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {
    
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        // Créationd d'une page simple
        final VerticalLayout layout = new VerticalLayout();
        
        // Création d'un ou plusieurs champs de text
        final TextField firstnameTextField = new TextField();
        firstnameTextField.setCaption("Insérez votre nom ci-dessous :");
        firstnameTextField.setPlaceholder("Votre nom ici"); // Vaadin 14 .setPlaceholder(""); | Vaadin 8 .setInputPrompt("");
        firstnameTextField.setRequiredIndicatorVisible(true);
        final TextField lastnameTextField = new TextField();
        lastnameTextField.setCaption("Insérez votre prénom ci-dessous :");
        lastnameTextField.setRequiredIndicatorVisible(true);
        lastnameTextField.setPlaceholder("Votre prénom ici");
        
        // Création d'une liste sélection ouverte - ListSelect
        ListSelect<String> selectGenre = new ListSelect<>();
        
        // Création d'une liste de sélection fermée - ComboBox
        ComboBox selectCodePostal = new ComboBox();
        
        // Création d'un sélecteur de date - DateTimeField with DatePicker
        DateTimeField captionBirthday = new DateTimeField();
        captionBirthday.setValue(LocalDateTime.now());
        captionBirthday.setCaption("Sélectionnez votre age :");
        
        // Ajouts des éléments dans la ou les liste(s) de sélection
        selectGenre.setCaption("Sélectionnez votre sexe :");
        selectGenre.setItems("Homme", "Femme");
        selectGenre.setRequiredIndicatorVisible(true);
        selectCodePostal.setCaption("Sélectionnez votre code postal :");
        selectCodePostal.setItems("95000","95100","95200","95300","95400","95500","95600","95700","95800","95900","96000");
        selectCodePostal.setRequiredIndicatorVisible(true);
        selectCodePostal.setPlaceholder("Votre code postal");
        
        // Choix du nombre d'éléments à laisser transparaitre pour l'une liste de sélection
        selectGenre.setRows(2);

        // Création d'un bouton
        Button buttonResult = new Button("Résultat");
        
        // Création de l'action d'un bouton
        buttonResult.addClickListener((Button.ClickEvent e) -> {
            
            // Récupération des valeurs saisi dans le ou les champs de text
            String firstnameValue = firstnameTextField.getValue();
            String lastnameValue = lastnameTextField.getValue();
            
            // Récupération d'un élément sélectionné dans une liste ouverte - ListSelect
            String genreValue = "";
            String checkGenreValue = "";
            Set<String> genreValueTmp = selectGenre.getSelectedItems();
            
            // Calcul de l'âge
            DateFormat DateFormat = new DateFormat();
            String dateBirthday = DateFormat.DateTimeField("YYYY-MM-dd",captionBirthday);
            //--
            GenerateBirthday birthday = new GenerateBirthday();
            Integer yearsOld = birthday.getYearsOld(dateBirthday);
            System.out.println("dateBirthdayResult : "+yearsOld);
            //--
            String dateBirthdayFromatFr = DateFormat.DateTimeField("dd/MM/YYYY",captionBirthday);
            String majeur = "";
            if(yearsOld>=18){ majeur = "Vous êtes né le "+dateBirthdayFromatFr+" et vous êtes majeur !"; }
            else{ majeur = "Vous êtes né le "+dateBirthdayFromatFr+" et vous êtes mineur !"; }
            
            // Vérification de la valeur Set réupérée dans le sélecteur
            for(String checkGenreValueTmp : genreValueTmp){
                checkGenreValue = checkGenreValueTmp;
            }
            if(checkGenreValue=="Homme"){ genreValue="un Homme"; }
            else if(checkGenreValue=="Femme"){ genreValue="une Femme"; }
            else{ genreValue="null"; }
            // Vérification de valeur en console
            System.out.println("majeur : "+majeur+"\ngenreValueTmp : "+genreValueTmp+" - checkGenreValue : "+checkGenreValue+" - genreValue : "+genreValue);
            
            // Récupération d'un élément sélectionné dans une liste fermée - ComboBox
            Optional<String> codePostalValueTmp = selectCodePostal.getSelectedItem();
            String codePostalValue = "null";
            // Vérification de la valeur Optional récupérée dans le sélecteur
            if(codePostalValueTmp.isPresent()){
                codePostalValue = codePostalValueTmp.get();
            }else{ codePostalValue = "null"; }
            // Vérification de valeur en console
            System.out.println("codePostalValue : "+codePostalValue);
            
            // Création d'une erreur
            UserError error1 = new UserError("Oups !");
            
            // Vérification des valeur saisi avant d'effectuer la finalité de l'action
            if(firstnameValue==""){ firstnameTextField.setComponentError(error1); }
            if(lastnameValue==""){ lastnameTextField.setComponentError(error1); }
            if(checkGenreValue==""){ selectGenre.setComponentError(error1); }
            //if(codePostalValue==""){ selectCodePostal.setComponentError(error1); }
            if( (firstnameValue!="") && (lastnameValue!="")){
                
                // Création de la valeur complète des saisis
                String result = "Bonjour "+firstnameValue+' '+lastnameValue+" !<br>"+majeur+"<br>Vous êtes "+genreValue+" et vous habitez dans le "+codePostalValue+".";
                
                // Création d'un nouveau titre - Label
                Label labelFinal = new Label(result);

                // Afficher une notification visuel
                Notification.show(labelFinal.getValue());

                // Ajout d'un élément dans la page simple
                layout.addComponent(labelFinal);
                
            }
        });
        
        layout.addComponents(firstnameTextField, lastnameTextField, selectGenre, selectCodePostal, captionBirthday, buttonResult);
        
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
