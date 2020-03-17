<header>
    <h1>Mijn huisdieren</h1>
    <nav>
        <ul>
            <li ${param.title eq 'Home'?'id="actual"':""}>
                    <a href="Controller?command=home">Home</a></li>
            <li ${param.title eq "Add"?"id='actual'":""}>
                    <a href="add.jsp">Voeg Toe</a></li>
            <li ${param.title eq "Overview"?"id='actual'":""}>
                    <a href="Controller?command=overview">Overzicht</a></li>
        </ul>
    </nav>
</header>