<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:if test="${not empty sessionScope.successMessage}">
    <script>
        $(document).ready(function() {
             $.Notify({
                 type: 'success', 
                 caption: "${successCaption}", 
                 timeout: 5000,
                 icon: "<span class='mif-thumbs-up'></span>",
                 content: "${successMessage}"
             });
        });
    </script>
    <c:set scope="session" var="successMessage" />
</c:if>

<c:if test="${not empty sessionScope.infoMessage}">
    <script>
        $(document).ready(function() {
             $.Notify({
                 type: 'info', 
                 caption: "${infoCaption}", 
                 timeout: 5000,
                 icon: "<span class='mif-info'></span>",
                 content: "${infoMessage}"
             });
        });
    </script>
    <c:set scope="session" var="infoMessage" />
</c:if>    

<c:if test="${not empty sessionScope.warnMessage}">
    <script>
        $(document).ready(function() {
             $.Notify({
                 type: 'warning', 
                 caption: "${warnCaption}", 
                 timeout: 5000,
                 icon: "<span class='mif-warning'></span>",
                 content: "${warnMessage}"
             });
        });
    </script>
    <c:set scope="session" var="warnMessage" />
</c:if>

<c:if test="${not empty sessionScope.alertMessage}">
    <script>
        $(document).ready(function() {
             $.Notify({
                 type: 'alert', 
                 caption: "${alertCaption}", 
                 timeout: 5000,
                 icon: "<span class='mif-security'></span>",
                 content: "${alertMessage}"
             });
        });
    </script>
    <c:set scope="session" var="alertMessage" />
</c:if>