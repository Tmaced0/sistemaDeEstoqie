package controller;

import dao.CadastroUserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import model.CadastroUsuarioModel;

@WebServlet("/cadastro")
public class CadastroController extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        CadastroUsuarioModel user = new CadastroUsuarioModel();
        
        user.setNome(request.getParameter("nameFist"));
        user.setNome(request.getParameter("sobrenome"));
        user.setNome(request.getParameter("matricula"));
        user.setNome(request.getParameter("cpf"));
        user.setNome(request.getParameter("sexo"));
        user.setNome(request.getParameter("email"));
        user.setNome(request.getParameter("telefone"));
        user.setNome(request.getParameter("usuario"));
        user.setNome(request.getParameter("senha"));
        user.setNome(request.getParameter("funcao"));
        user.setNome(request.getParameter("cep"));
        user.setNome(request.getParameter("endereco"));
        user.setNome(request.getParameter("cidade"));
        user.setNome(request.getParameter("bairro"));
        user.setNome(request.getParameter("estado"));
        user.setNome(request.getParameter("numero"));
        user.setNome(request.getParameter("complemento"));
        
        
        CadastroUserDAO dao = new CadastroUserDAO();
        
        if(dao.cadastrar(user)) {
            response.sendRedirect("pages/dashboard.html");
        }else{
            response.sendRedirect("pages/cadastro.html");
        }

                
    }
}
