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
    private String status;
    private boolean type;
    
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
    public String getStatus() {
		return status;
	}
    public boolean isType() {
		return type;
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
	public void setStatus(String status) {
		this.status = status;
	}
	public void setType(boolean type) {
		this.type = type;
	}
	
     
    

    
    
    
	

}
