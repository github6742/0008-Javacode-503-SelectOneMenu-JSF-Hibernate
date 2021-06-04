package bean;

import impl.PaisDaoImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import model.Tbpais;
import dao.PaisDao;

@ManagedBean
@RequestScoped
public class PaisBean implements Serializable{

    private List<SelectItem> listaPaises;
    private Tbpais pais;
    
    public PaisBean() {
        pais = new Tbpais();
    }

    public Tbpais getPais() {
        return pais;
    }

    public void setPais(Tbpais pais) {
        this.pais = pais;
    }

    public List<SelectItem> getListaPaises() {
        this.listaPaises = new ArrayList<SelectItem>();
        PaisDao pDao = new PaisDaoImpl();
        
        List<Tbpais> p = pDao.listaPaises();
        listaPaises.clear();
        
        for (Tbpais pais : p){
            SelectItem paisItem = new SelectItem(pais.getIdPais(),pais.getNombrePais());
            this.listaPaises.add(paisItem);
        }
        return listaPaises;
    }
    
    
}
