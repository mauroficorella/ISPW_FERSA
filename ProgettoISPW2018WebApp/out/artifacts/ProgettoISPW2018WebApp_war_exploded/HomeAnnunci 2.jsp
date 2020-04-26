<%@ page import="java.util.ArrayList" %>
<%@ page import="Entity.Annuncio" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="Entity.Filtri" %>
<%@ page import="java.sql.Date" %>
<%@ page import="Thread.ImportTimer" %>
<%@ page import="Entity.Ordinamento" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: mauroficorella
  Date: 2019-01-10
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="annunciAppartamentiBean" scope="request" class="Bean.AnnunciAppartamentiBean"/>
<jsp:useBean id="ordinamentoAnnunciAppartamentiBean" scope="request" class="Bean.OrdinamentoAnnunciAppartamentiBean"/>
<jsp:useBean id="filtraggioAnnunciAppartamentiBean" scope="request" class="Bean.FiltraggioAnnunciAppartamentiBean"/>
<jsp:setProperty name="annunciAppartamentiBean" property="*"/>
<jsp:setProperty name="ordinamentoAnnunciAppartamentiBean" property="*"/>
<jsp:setProperty name="filtraggioAnnunciAppartamentiBean" property="*"/>

<%
    ArrayList<Annuncio> lista = new ArrayList<Annuncio>();
    ImportTimer importTimer = new ImportTimer();
    try {
        lista = annunciAppartamentiBean.getAllAnnunci();
        importTimer.start();

    } catch (SQLException e) {
        e.printStackTrace();
    }
%>
<%
    if (request.getParameter("cerca") != null) {
        if (request.getParameter("prezzoMin") != "") {
            filtraggioAnnunciAppartamentiBean.setPrezzoMin(Double.parseDouble(request.getParameter("prezzoMin")));
        } else {
            filtraggioAnnunciAppartamentiBean.setPrezzoMin(0);
        }

        if (request.getParameter("prezzoMax") != "") {
            filtraggioAnnunciAppartamentiBean.setPrezzoMax(Double.parseDouble(request.getParameter("prezzoMax")));
        } else {
            filtraggioAnnunciAppartamentiBean.setPrezzoMax(0);
        }

        if (request.getParameter("luogo") != null) {
            filtraggioAnnunciAppartamentiBean.setLuogo(request.getParameter("luogo"));
        }


        if (request.getParameter("check-in") != null) {
            filtraggioAnnunciAppartamentiBean.setCheck_in(Date.valueOf(request.getParameter("check-in")));
        }

        if (request.getParameter("check-out") != null) {
            filtraggioAnnunciAppartamentiBean.setCheck_out(Date.valueOf(request.getParameter("check-out")));
        }

        if (request.getParameter("nummaxpersone") != "") {
            filtraggioAnnunciAppartamentiBean.setNum_max_persone(Integer.valueOf(request.getParameter("nummaxpersone")));
        } else {
            filtraggioAnnunciAppartamentiBean.setNum_max_persone(0);
        }

        if (request.getParameter("tipostanza") != null) {
            if (request.getParameter("tipostanza").equalsIgnoreCase("Stanza condivisa")) {
                filtraggioAnnunciAppartamentiBean.setTipo_alloggio("Stanza condivisa");
            } else if (request.getParameter("tipostanza").equalsIgnoreCase("Appartamento intero")) {
                filtraggioAnnunciAppartamentiBean.setTipo_alloggio("Appartamento intero");
            } else if (request.getParameter("tipostanza").equalsIgnoreCase("Stanza privata")) {
                filtraggioAnnunciAppartamentiBean.setTipo_alloggio("Stanza privata");
            } else {
                filtraggioAnnunciAppartamentiBean.setTipo_alloggio("Tutti");
            }
        } else {
            filtraggioAnnunciAppartamentiBean.setTipo_alloggio("Tutti");
        }

        if (request.getParameter("sesso")!=null)    {
            if (request.getParameter("sesso").equalsIgnoreCase("Solo donne"))   {
                filtraggioAnnunciAppartamentiBean.setSesso("donne");
            } else if(request.getParameter("sesso").equalsIgnoreCase("Solo uomini"))    {
                filtraggioAnnunciAppartamentiBean.setSesso("uomini");
            } else  {
                filtraggioAnnunciAppartamentiBean.setSesso("tutti");
            }
        }

        if (request.getParameter("numletti") != null) {
            if (request.getParameter("numletti").equalsIgnoreCase("1")) {
                filtraggioAnnunciAppartamentiBean.setNum_letti(1);
            } else if (request.getParameter("numletti").equalsIgnoreCase("2")) {
                filtraggioAnnunciAppartamentiBean.setNum_letti(2);
            } else if (request.getParameter("numletti").equalsIgnoreCase("3")) {
                filtraggioAnnunciAppartamentiBean.setNum_letti(3);
            } else if (request.getParameter("numletti").equalsIgnoreCase("4")) {
                filtraggioAnnunciAppartamentiBean.setNum_letti(4);
            } else if (request.getParameter("numletti").equalsIgnoreCase("5")) {
                filtraggioAnnunciAppartamentiBean.setNum_letti(5);
            } else {
                filtraggioAnnunciAppartamentiBean.setNum_letti(0);
            }
        } else {
            filtraggioAnnunciAppartamentiBean.setNum_letti(0);
        }

        if (request.getParameter("riscaldamento") == null) {
            filtraggioAnnunciAppartamentiBean.setRiscaldamento(null);
        } else {
            filtraggioAnnunciAppartamentiBean.setRiscaldamento(true);
        }

        if (request.getParameter("aria") == null) {
            filtraggioAnnunciAppartamentiBean.setAria(null);
        } else {
            filtraggioAnnunciAppartamentiBean.setAria(true);
        }

        if (request.getParameter("acqua") == null) {
            filtraggioAnnunciAppartamentiBean.setAcqua(null);
        } else {
            filtraggioAnnunciAppartamentiBean.setAcqua(true);
        }

        if (request.getParameter("elettricita") == null) {
            filtraggioAnnunciAppartamentiBean.setElettricita(null);
        } else {
            filtraggioAnnunciAppartamentiBean.setElettricita(true);
        }

        if (request.getParameter("gas") == null) {
            filtraggioAnnunciAppartamentiBean.setGas(null);
        } else {
            filtraggioAnnunciAppartamentiBean.setGas(true);
        }

        if (request.getParameter("condominio") == null) {
            filtraggioAnnunciAppartamentiBean.setCondominio(null);
        } else {
            filtraggioAnnunciAppartamentiBean.setCondominio(true);
        }

        if (request.getParameter("parcheggio") == null) {
            filtraggioAnnunciAppartamentiBean.setParcheggio(null);
        } else {
            filtraggioAnnunciAppartamentiBean.setParcheggio(true);
        }

        if (request.getParameter("pulizie") == null) {
            filtraggioAnnunciAppartamentiBean.setPulizie(null);
        } else {
            filtraggioAnnunciAppartamentiBean.setPulizie(true);
        }

        if (request.getParameter("wifi") == null) {
            filtraggioAnnunciAppartamentiBean.setWifi(null);
        } else {
            filtraggioAnnunciAppartamentiBean.setWifi(true);
        }

        if (request.getParameter("telefonia") == null) {
            filtraggioAnnunciAppartamentiBean.setTelefonia(null);
        } else {
            filtraggioAnnunciAppartamentiBean.setTelefonia(true);
        }

        if (request.getParameter("sorveglianza") == null) {
            filtraggioAnnunciAppartamentiBean.setSorveglianza(null);
        } else {
            filtraggioAnnunciAppartamentiBean.setSorveglianza(true);
        }

        if (request.getParameter("ascensore") == null) {
            filtraggioAnnunciAppartamentiBean.setAscensore(null);
        } else {
            filtraggioAnnunciAppartamentiBean.setAscensore(true);
        }

        if (request.getParameter("portierato") == null) {
            filtraggioAnnunciAppartamentiBean.setPortierato(null);
        } else {
            filtraggioAnnunciAppartamentiBean.setPortierato(true);
        }

        if (request.getParameter("animali") == null) {
            filtraggioAnnunciAppartamentiBean.setAnimali(null);
        } else {
            filtraggioAnnunciAppartamentiBean.setAnimali(true);
        }

        if (request.getParameter("fumatori") == null) {
            filtraggioAnnunciAppartamentiBean.setFumatori(null);
        } else {
            filtraggioAnnunciAppartamentiBean.setFumatori(true);
        }

        if (request.getParameter("solopaesiconvenzionati") == null) {
            filtraggioAnnunciAppartamentiBean.setPaesi_conv(null);
        } else {
            filtraggioAnnunciAppartamentiBean.setPaesi_conv(true);
        }

        if (request.getParameter("studente") == null) {
            filtraggioAnnunciAppartamentiBean.setStudente(null);
        } else {
            filtraggioAnnunciAppartamentiBean.setStudente(true);
        }

        if (request.getParameter("lavoratore") == null) {
            filtraggioAnnunciAppartamentiBean.setLavoratore(null);
        } else {
            filtraggioAnnunciAppartamentiBean.setLavoratore(true);
        }

        try {
            Filtri filter = filtraggioAnnunciAppartamentiBean.setFiltri();
            lista = filtraggioAnnunciAppartamentiBean.filtraAnnunci(filter);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
%>
<%
    if (request.getParameter("ordina") != null) {
        String order = "";
        if (request.getParameter("cbOrder") != null) {
            if (request.getParameter("cbOrder").equalsIgnoreCase("Prezzo crescente")) {
                order = "Prezzo crescente";
            } else if (request.getParameter("cbOrder").equalsIgnoreCase("Prezzo decrescente")) {
                order = "Prezzo decrescente";
            } else if (request.getParameter("cbOrder").equalsIgnoreCase("Valutazioni migliori-peggiori")) {
                order = "Valutazioni migliori-peggiori";
            } else if (request.getParameter("cbOrder").equalsIgnoreCase("Valutazioni peggiori-migliori")) {
                order = "Valutazioni peggiori-migliori";
            }
            ordinamentoAnnunciAppartamentiBean.setOrder(order);
            Ordinamento ordinamento = ordinamentoAnnunciAppartamentiBean.setOrdinamento();
            lista = ordinamentoAnnunciAppartamentiBean.ordinaAnnunci(lista, ordinamento);
        }
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Annunci Appartamenti</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="./js/bootstrap.min.js"></script>
    <script src="libs/jquery.min.js"></script>
    <link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>

<header>
    <h1>Annunci Appartamenti</h1>
    <h3>Il sistema mostra una lista di Appartamenti filtrabile e ordinabile</h3>
</header>


<section>
    <nav>
        <form>
            <h4>
                Luogo: <input id="luogo" type="text" name="luogo" required><br><br>
                Data check-in (AAAA-MM-GG): <input id="check-in" type="text" name="check-in" required><br><br>
                Data check-out (AAAA-MM-GG): <input id="check-out" type="text" name="check-out" required><br><br>
                <button name="cerca" id="cerca">Ricerca</button>
                <br>
            </h4>
            <ul>
                <h2>Lista di filtri</h2>
                <h4>
                    Prezzo minimo (INSERIRE UN VALORE MAGGIORE DI 0): <input type="text" id="prezzoMin" name="prezzoMin"><br><br>
                    Prezzo massimo (INSERIRE UN VALORE MAGGIORE DI 0): <input type="text" id="prezzoMax" name="prezzoMax">
                </h4>
                <li><input type="checkbox" id="riscaldamento" name="riscaldamento"> Riscaldamento<br></li>
                <li><input type="checkbox" id="aria" name="aria"> Aria<br></li>
                <li><input type="checkbox" id="acqua" name="acqua"> Acqua<br></li>
                <li><input type="checkbox" id="elettricita" name="elettricita"> Elettricita<br></li>
                <li><input type="checkbox" id="gas" name="gas"> Gas<br></li>
                <li><input type="checkbox" id="condominio" name="condominio"> Condominio<br></li>
                <li><input type="checkbox" id="parcheggio" name="parcheggio"> Parcheggio<br></li>
                <li><input type="checkbox" id="pulizie" name="pulizie"> Pulizie<br></li>
                <li><input type="checkbox" id="wifi" name="wifi"> WIFI<br></li>
                <li><input type="checkbox" id="telefonia" name="telefonia"> Telefonia<br></li>
                <li><input type="checkbox" id="sorveglianza" name="sorveglianza"> Sorveglianza<br></li>
                <li><input type="checkbox" id="ascensore" name="ascensore"> Ascensore<br></li>
                <li><input type="checkbox" id="portierato" name="portierato"> Portierato<br></li>
                <li><input type="checkbox" id="animali" name="animali"> Animali<br></li>
                <li><input type="checkbox" id="fumatori" name="fumatori"> Fumatori<br></li>
                <li><input type="checkbox" id="solopaesiconvenzionati" name="solopaesiconvenzionati"> Solo paesi
                    convenzionati<br></li>
                <li><input type="checkbox" id="studente" name="studente"> Studente<br></li>
                <li><input type="checkbox" id="lavoratore" name="lavoratore"> Lavoratore<br></li>
                <li>
                    Numero massimo persone: <input type="text" id="nummaxpersone" name="nummaxpersone"><br>
                </li>
                <h4>Sesso:<br>
                    <li><select name="sesso">
                        <option value="selezionasesso" disabled selected>Seleziona una preferenza:</option>
                        <option value="Solo donne">Solo donne</option>
                        <option value="Solo uomini">Solo uomini</option>
                        <option value="Tutti">Entrambi</option>
                    </select></li>
                </h4>
                <h4>Tipo stanza:<br>
                    <li><select name="tipostanza">
                        <option value="selezionatipologia" disabled selected>Seleziona una tipologia:</option>
                        <option value="Stanza condivisa">Stanza condivisa</option>
                        <option value="Appartamento intero">Appartamento intero</option>
                        <option value="Stanza privata">Stanza privata</option>
                    </select></li>
                </h4>
                <h4>Numero letti:<br>
                    <li><select name="numletti">
                        <option value="selezionanumero" disabled selected>Seleziona un numero:</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                    </select></li>
                </h4>


            </ul>
        </form>

    </nav>
    <article>
        <form>
            <h3>Ordina per:

                <select id="cbOrder" name="cbOrder" required>
                    <option value="" disabled>Ordina per:</option>
                    <option value="Prezzo crescente">Prezzo crescente</option>
                    <option value="Prezzo decrescente">Prezzo decrescente</option>
                    <option value="Valutazioni migliori-peggiori">Valutazioni migliori-peggiori</option>
                    <option value="Valutazioni peggiori-migliori">Valutazioni peggiori-migliori</option>
                </select>
                <button name="ordina" id="ordina">Ordina</button>

            </h3>
        </form>

        <form>
            <ul id="list">

                <%
                    if (lista.isEmpty()) {
                %>
                <script>
                    alert("Nessun annuncio trovato con i filtri selezionati");
                </script>
                <%
                    }
                    for (int i = 0; i < lista.size(); i++) {
                %>
                <li id="<%=i%>">
                    <div class="row">
                        <div class="col-sm-3">
                            <img src="Img/home.png" alt="casa" width="64" height="64"><br>
                        </div>
                        <div class="col-sm-9">
                            <h4>
                                <%=lista.get(i).getNome()%> <br>
                                <%=lista.get(i).getLuogo()%> <br>
                                <%=lista.get(i).getPrezzo()%> <br>
                                <%=lista.get(i).getValutazione()%>
                            </h4>
                        </div>

                    </div>
                </li>
                <%
                    }
                %>
            </ul>
        </form>
    </article>
</section>
</body>
</html>
