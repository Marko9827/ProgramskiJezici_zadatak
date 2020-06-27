  $("#predmeti").hide();
        $("#studenti").hide();
        $("head").append(`<style type="text/css">
        * {
    padding: 0px;
    margin: 0px;
    font-family: arial;
    outline-style: none !important;
}

table,
th,
td {
    border: 1px solid #607D8B;
}

.container {
    margin: 10px;
}

.container input[type=text] {


    border: 2px solid #607D8B;
    padding: 10px;
    font-size: 15px;
    font-weight: bold;
    color: #607D8B;
    border-bottom: 0px;
    padding-right: 40px;
    border-top-right-radius: 19px;
    width: 465px;

}

.container button {

    background: #607D8B;
    border-top-right-radius: 15px;
    height: 37px;
    border: 0px;
    position: absolute;
    margin-top: 2px;
    color: white;
    padding-left: 10px;
    padding-right: 10px;
    margin-left: -35px;
    font-size: 23px;

}

#tabela thead tr th {
    width: fit-content;
}

table {
    border-collapse: collapse;
    width: fit-content;
}

th,
td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #f2f2f2
}

th {
    background-color: #607D8B;
    color: white;
}

#json_celo {

    background: white;
    min-width: 600px;
    border: 3px solid #607D8B;
    padding: 10px;
    max-width: fit-content;
    overflow: auto;

}

#json_celo span {

    background: #607D8B;
    color: white;
    padding: 3px;
    border-radius: 4px;
    padding-right: 6px;
    padding-left: 6px;

}

#ko_je_pravio {
    background: #607D8B;
    width: fit-content;
    padding: 10px;
    font-size: 25px;
    color: white;
    font-weight: bold;
    font-family: arial;
    border-top-left-radius: 15px;
    border-top-right-radius: 15px;
}

::-webkit-scrollbar {
    height:5px;
    width:5px;
}


::-webkit-scrollbar-track {
    background: #f1f1f1; 
}


::-webkit-scrollbar-thumb {
    background: #607d8ba6 
}


::-webkit-scrollbar-thumb:hover {
    background: #607D8B; 
}

</style>`);
        var domen = "http://localhost:8080/";

        function get_ajax() {
            $("#tabela tbody").empty();
            var url2 = "";


            url2 = $("input[type=text]").val();
            if (url2 == "") {
                url2 = "profesori/";
                $("input[type=text]").val(url2);
            }

            if (url2.includes("profesori")) {
                $("#predmeti").hide();
                $("#profesori").show();
                $("#studenti").hide();
            }
            if (url2.includes("predmeti")) {
                $("#predmeti").show();
                $("#profesori").hide();
                $("#studenti").hide();
            }
            if (url2.includes("studenti")) {
                $("#predmeti").hide();
                $("#profesori").hide();
                $("#studenti").show();
            }


            $.ajax({
                url: domen + url2,
                method: 'GET',
                /*
                                cache: false,
                                type: "text/json",
                                async: false,
                                contentType: "application/x-www-form-urlencoded; charset=UTF-8",*/

                success: function(response) {
                    try {
                        var len = response.length;
                        for (var i = 0; i < len; i++) {
                            if (url2.includes("profesori")) {
                                var professorId = response[i].professorId;
                                var forename = response[i].forename;
                                var surname = response[i].surname;
                                var jmbg = response[i].jmbg;
                                var plata = response[i].salary;
                                var Email = response[i].email;

                                var tr_str = "<tr>" +
                                    "<td align='center'>" + professorId + "</td>" +
                                    "<td align='center'>" + forename + "</td>" +
                                    "<td align='center'>" + surname + "</td>" +
                                    "<td align='center'>" + jmbg + "</td>" +
                                    "<td align='center'>" + plata + "</td>" +
                                    "<td align='center'>" + Email + "</td>" +
                                    "</tr>";
                                $("#tabela tbody").append(tr_str);

                                try {
                                    //  JSON.parse(response);
                                } catch (e) {}
                            }
                            if (url2.includes("predmeti")) {
                                var subject_id = response[i].subjectId;
                                var name = response[i].name;
                                var year_old_studies = response[i].yearOfStudies;
                                var description = response[i].description;
                                var pprofessor_id = response[i].professorId;


                                var tr_str = "<tr>" +
                                    "<td align='center'>" + subject_id + "</td>" +
                                    "<td align='center'>" + name + "</td>" +
                                    "<td align='center'>" + year_old_studies + "</td>" +
                                    "<td align='center'>" + description + "</td>" +
                                    "<td align='center'>" + pprofessor_id + "</td>" +
                                    "</tr>";
                                $("#tabela tbody").append(tr_str);

                                try {
                                    //  JSON.parse(response);
                                } catch (e) {}
                            }
                            if (url2.includes("studenti")) {
                                var student_id = response[i].studentsId;
                                var forename = response[i].forename;
                                var surname = response[i].surname;
                                var jmbg = response[i].jmbg;
                                var indeks = response[i].index;
                                var predmet_name = response[i].predmet_name;
                                var predmet_id = response[i].faks;

                                var tr_str = "<tr>" +
                                    "<td align='center'>" + student_id + "</td>" +
                                    "<td align='center'>" + forename + "</td>" +
                                    "<td align='center'>" + surname + "</td>" +
                                    "<td align='center'>" + jmbg + "</td>" +
                                    "<td align='center'>" + predmet_name + "</td>" +
                                    "<td align='center'>" + indeks + "</td>" +
                                    "<td align='center'>" + predmet_id + "</td>" +
                                    "</tr>";
                                $("#tabela tbody").append(tr_str);

                                try {
                                    //  JSON.parse(response);
                                } catch (e) {}
                            }

                        }
                        document.querySelector("#json_celo").innerHTML =
                            `<span id="link_otvori" onclick="otvorilink()" title="Otvara novi link ( ` + domen + $("input[type=text]").val() + ` ) "> Otvori u novoj kartici <i class="fas fa-external-link-square-alt"></i></span><br><br><span>JSON Broj podataka po redovima u tabeli : ` + response.length + `</span>` +
                            `<br><br> JSON originalni bez tabele : <br> <br>` + JSON.stringify(response) + ``;

                    } catch (e) {
                        console.log(e);
                    }

                }

            });



        }

        function otvorilink() {
            window.open(domen + $("input[type=text]").val(), "_blank");
        };

        function enter_key(e) {
            if (e.keyCode == 13) {
                get_ajax();
                return false;
            }
        }
        get_ajax();