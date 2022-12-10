from email.message import EmailMessage
import ssl
import smtplib
from email.mime.text import MIMEText
from email.mime.multipart import MIMEMultipart
import sys

# send_map_by_email(email_rec,denumire_locatie, latitudine, longitudine, data, ora, strada):
email_sender = 'andrei.grosoiu@gmail.com'
email_password = "hgxupmskgocflufw"
email_receiver = sys.argv[1]
denumire_locatie = sys.argv[2]
latitudine = sys.argv[3]
longitudine = sys.argv[4]
data = sys.argv[5]
ora = sys.argv[6]
strada = sys.argv[7]

subject = "Programarea ta la BCR"
html = f"""

<!DOCTYPE html>
<html>
<body>
    <div style="text-align: center;">
    <img src="https://i.imgur.com/BTNUKW3.png" alt="logo"> 
    </div>
    <div style="text-align: center;">  
    <img src="https://i.imgur.com/kPD45rn.png" alt="Girl">
    </div>
    <div style="text-align: center; font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;">
    

        <p class="v1:3" style="box-sizing: border-box; font-size: 38px; color:#22426d">
            Salut,
            <br><br>

            Programarea ta la  <b> {denumire_locatie} </b> este confirmata.    <br> <br>
            
            <b>Detalii programare: </b> <br> <br>
            
            Locatie: <b>{denumire_locatie} </b><br>
            Data si interval orar: <b>{data}, {ora} </b> <br>
            Adresa: <b>{strada} </b>  <br>

            harta: <br> <img src="https://maps.googleapis.com/maps/api/staticmap?center={latitudine},{longitudine}&zoom=14&size=400x400&markers=color:blue%7Clabel:B%7C{latitudine},{longitudine}&key=AIzaSyCjPrn6xkqvduxlGJxFfb-Weic5ReEcb14"</img> <br>
            <a href="https://www.google.com/maps/search/?api=1&query={latitudine},{longitudine}">Afiseaza traseul pe harta</a><br> <br>
            <a href="https://www.google.com">Anuleaza Vizita</a><br>
            <br>
        <br>
        <br>
        Pentru siguranta ta si a noastra, te rugam sa porti masca de protectie pe tot parcursul vizitei. Pe curand! <br> 
            Cu drag, <br> Echipa BCR <br>
        </p>


    </h2>
</div>

<div style="text-align: center;">
    <img src="https://i.imgur.com/BTNUKW3.png" alt="logo"> 
    </div>


</body>
</html>


"""

em = MIMEMultipart("alternative")
em['From'] = email_sender
em['To'] = email_receiver
em['Subject'] = subject

part1 = MIMEText(html, "html")
em.attach(part1)

context = ssl.create_default_context()

with smtplib.SMTP_SSL('smtp.gmail.com', 465, context=context) as smtp:
    smtp.login(email_sender,email_password)
    smtp.sendmail(email_sender, email_receiver, em.as_string())


