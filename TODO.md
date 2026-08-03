# In-Class Demonstration Flow

This repository has these branches:

- **`main`** — the in-class version. Some code is blanked out with `TODO` comments. We fill these in together during the demonstration.
- **[`complete`](https://github.com/cnacha-mfu/sample-web-servlet/tree/complete)** — the finished code for every example. Use it to catch up or check your work.
- **[`javascript`](https://github.com/cnacha-mfu/sample-web-servlet/tree/javascript)** and **[`jsp`](https://github.com/cnacha-mfu/sample-web-servlet/tree/jsp)** — the original per-topic samples, kept for reference.

**Start the web server first** and leave it running — it redeploys automatically when code changes:

```
mvn jetty:run
```

Then open <http://localhost:8080> — the home page links to every demo. Follow the steps in order; each one adds a single new idea.

---

## Step 1: Your first servlet

**File:** `src/main/java/com/example/HelloServlet.java`

**Idea:** a servlet is a Java class the web server calls to answer a request. `@WebServlet` maps it to a URL; `init()`, `service()`, `destroy()` are its life cycle.

**Fill in together:**
1. Set the response content type to `text/html`.
2. Get a `PrintWriter` from the response and print an HTML greeting.

**Try it:** open <http://localhost:8080/hello>. Watch the console for the `init` message — when did it print?

**Solution:** [HelloServlet](https://github.com/cnacha-mfu/sample-web-servlet/blob/complete/src/main/java/com/example/HelloServlet.java)

---

## Step 2: Read a request parameter

**File:** `HelloServlet.java` (same file)

**Idea:** data from the browser arrives as request parameters — `request.getParameter("name")`.

**Fill in together:** read the `name` parameter and greet that name instead of the fixed text.

**Try it:** open <http://localhost:8080/hello?name=Nacha>.

**Solution:** [HelloServlet](https://github.com/cnacha-mfu/sample-web-servlet/blob/complete/src/main/java/com/example/HelloServlet.java)

---

## Step 3: JavaScript in the browser

**Files:** `src/main/webapp/hello.html`, `loop.html`, `colortext.html`

**Idea:** JavaScript runs *in the browser*, not on the server. It can react to events and change the page (the DOM) without reloading.

**Fill in together:**
1. `hello.html` — show an alert when the page loads.
2. `loop.html` — create and append a new paragraph every second using `setTimeout`.
3. `colortext.html` — use jQuery to change text and color on button clicks.

**Try it:** open each page from the home page.

**Solution:** [hello.html](https://github.com/cnacha-mfu/sample-web-servlet/blob/complete/src/main/webapp/hello.html) · [loop.html](https://github.com/cnacha-mfu/sample-web-servlet/blob/complete/src/main/webapp/loop.html) · [colortext.html](https://github.com/cnacha-mfu/sample-web-servlet/blob/complete/src/main/webapp/colortext.html)

---

## Step 4: JSP — HTML with Java inside

**File:** `src/main/webapp/hello.jsp`

**Idea:** a JSP is an HTML page that can contain Java: scriptlets `<% ... %>` for code and expressions `<%= ... %>` for printing values. The server turns it into a servlet automatically.

**Fill in together:** read the `name` parameter in a scriptlet; if it is present, greet it with an expression, otherwise greet "Guest".

**Try it:** open <http://localhost:8080/hello.jsp?name=Nacha> and without the parameter.

**Solution:** [hello.jsp](https://github.com/cnacha-mfu/sample-web-servlet/blob/complete/src/main/webapp/hello.jsp)

---

## Step 5: Servlet + JSP working together

**Files:** `src/main/java/com/example/CalculatorServlet.java`, `src/main/webapp/calresult.jsp`

**Idea:** the servlet does the *logic*, the JSP does the *presentation*. The servlet passes data to the JSP with `request.setAttribute(...)` and hands over with `forward(...)`. **This is exactly the pattern the lab uses.**

**Fill in together:**
1. In the servlet — read parameters `num1` and `num2`, convert with `Integer.parseInt`, add them.
2. Put the result in a request attribute and forward to `calresult.jsp`.
3. In the JSP — show the attribute with `<%= request.getAttribute("result") %>`.

**Try it:** open <http://localhost:8080/calculate?num1=5&num2=7>.

**Solution:** [CalculatorServlet](https://github.com/cnacha-mfu/sample-web-servlet/blob/complete/src/main/java/com/example/CalculatorServlet.java) · [calresult.jsp](https://github.com/cnacha-mfu/sample-web-servlet/blob/complete/src/main/webapp/calresult.jsp)

---

## Step 6: AJAX — call a servlet without reloading

**File:** `src/main/webapp/ajaxcall.html`

**Idea:** JavaScript can call a servlet in the background (`$.ajax`) and put the response into the page — no page reload. This is what the lab's *challenge* asks for.

**Fill in together:** on button click, send the typed name to `/hello` with `$.ajax` and show the response text in the page.

**Try it:** open <http://localhost:8080/ajaxcall.html>, type a name, press Submit.

**Solution:** [ajaxcall.html](https://github.com/cnacha-mfu/sample-web-servlet/blob/complete/src/main/webapp/ajaxcall.html)

---

## Step 7: Integration test — how the lab grades you

**File:** `src/test/java/com/example/CalculatorIT.java` (already complete — read it together)

**Idea:** an integration test starts the real server, sends a real HTTP request to `/calculate`, and checks the response — the same way the lab's autograding checks your work.

**Try it:** stop the running server first (port 8080 must be free), then:

```
mvn verify
```

Maven starts Jetty, runs `CalculatorIT`, and stops Jetty. `BUILD SUCCESS` means the test passed.

**Solution:** [CalculatorIT](https://github.com/cnacha-mfu/sample-web-servlet/blob/complete/src/test/java/com/example/CalculatorIT.java)

---

## After class

You are now ready for the graded lab: [lab-web-jspservlet](https://github.com/maefahluang-uni/lab-web-jspservlet) — a BMI calculator built with exactly the Step 5 pattern (form → servlet → `setAttribute` → forward → JSP), verified with `mvn verify` (Step 7). Its challenge is Step 6.

> **Tip:** only one program can listen on port 8080 at a time. If `mvn jetty:run` or `mvn verify` fails with `Address already in use`, stop the other server first.
