try{

	Font f = Font.CreateFont(Font.TRUETYPE FONT, new FileInputStream(new File("Font path"))).deriveFont(Font.PLAIN, 24);


}catch(Exception ex){
	ex.printStackTrace();
}