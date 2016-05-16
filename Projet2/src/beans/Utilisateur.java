package beans;

public class Utilisateur {
	private int id;
    private String prenom;
    private String nom;
    private String login;
    private String motDePasse;
    private String societe;
    private String telephone;
    private String email;
    private boolean statusActif;
    private boolean statusAdmin;
    
    /*Constructors*/
    public Utilisateur() {}
    public Utilisateur(int id,
    				   String prenom,
					   String nom,
					   String login,
					   String motDePasse,
					   String societe,
					   String telephone,
					   Boolean statusActif,
					   Boolean statusAdmin) {
    	
    	this.id 		 = id;
		this.prenom    = prenom;
		this.nom 		 = nom;
		this.login 	 = login;
		this.motDePasse = motDePasse;
		this.societe    = societe;
		
		if (!statusActif) this.statusActif = statusActif.booleanValue();
		if (!statusAdmin)  this.statusAdmin  = statusAdmin.booleanValue();
    }
    
    /*Getters*/
    public int getId() {
		return id;
	}
    public String getPrenom() {
		return prenom;
	}
    public String getNom() {
    	return nom;
	}
    public String getLogin() {
		return login;
	}
    
    public String getMotDePasse() {
		return motDePasse;
	}
    public String getSociete() {
		return societe;
	}
    public String getTelephone() {
		return telephone;
	}
    public String getEmail() {
		return email;
	}
    public boolean getStatusActif() {
		return statusActif;
	}
    public boolean getStatusAdmin() {
		return statusAdmin;
	}
    
    /*Setters*/ 
	public void setId(int id) {
		this.id = id;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public void setLogin(String prenom, String nom) {
		this.login = prenom+'.'+nom;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public void setSociete(String societe) {
		this.societe = societe;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setStatusActif(boolean statusActif) {
		this.statusActif = statusActif;
	}
	public void setStatusAdmin(boolean statusAdmin) {
		this.statusAdmin = statusAdmin;
	}
	
	/*Others functions*/
	public boolean Valide() {
		return (motDePasse != null || motDePasse.length() != 0 
				|| email != null || email.length() != 0 
				|| prenom != null || prenom.length() != 0
				|| nom != null || nom.length() != 0);
	}
     
    

    
    
    
	

}
