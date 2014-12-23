void checkRights(String gruppo){
    if(gruppo.equals("AMMINISTRATORE")){
    	menuRicerche.setVisible(true);
    	menuInserimenti.setVisible(true);
    	menuSysTools.setVisible(true);
    }else{
    	menuRicerche.setVisible(true);
    	menuInserimenti.setVisible(false);
    }	
}