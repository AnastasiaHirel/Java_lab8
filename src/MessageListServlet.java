import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MessageListServlet extends ChatServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        // Установить кодировку HTTP-ответа UTF-8
        response.setCharacterEncoding("utf8");
        // Получить доступ к потоку вывода HTTP-ответа
        PrintWriter pw = response.getWriter();
        // Записть в поток HTML-разметку страницы
        pw.println("<html><head><meta http-equiv='Content-Type' " +
                "content='text/html; charset=utf-8'/><meta http-equiv='refresh' " +
                "content='10'></head>");
        pw.println("<body>");
        // В обратном порядке записать в поток HTML-разметку для каждого сообщения

        for (int i=0; i<=messages.size()-1; i++) {
            ChatMessage aMessage = messages.get(i);
            if ((Calendar.getInstance().getTimeInMillis()-messages.get(i).getTimestamp())/1000 <= messages.get(i).getSek())
                pw.println("<div><strong>" + aMessage.getAuthor().getName() + "</strong>: " + aMessage.getMessage() + "</div>");

        }

        pw.println("</body></html>");
    }
}