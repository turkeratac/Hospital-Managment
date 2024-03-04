
var prescriptionRecorder = 0;
var prescriptionIdArea = document.getElementById('prescriptionId');

document.addEventListener("DOMContentLoaded", function() {
    // Eğer prescriptionIdArea bir input alanı ise:
    if (prescriptionIdArea) {
        prescriptionIdArea.value = "RCT" + prescriptionRecorder;
    }

    // Eğer prescriptionIdArea bir metin alanı (div, span, vb.) ise:
    // prescriptionIdArea.textContent = "RCT" + prescriptionRecorder;
});




function saveThePrescriptionButton() {
    var patientName = document.getElementById('patientNameInput').value;
    var clinicName = document.getElementById('personelClinicNameArea').value;
    var personelName = document.getElementById('personelNameArea').value;
    var drugName = document.getElementById('drugListInput').value;
    var drugPrescribedDose = document.getElementById('drugPrescribedDose').value;
    var prescriptionDate = document.getElementById('prescriptionDate').value;
    var prescriptionId = document.getElementById('prescriptionId').value;
    var patientAge = document.getElementById('patientAge').value;
    var patientId = document.getElementById('patientId').value;
    var patientComplaint = document.getElementById('patientComplaint').value;
    var drugRecommendedDose = document.getElementById('drugRecommendedDose').value;
    var drugMaxDose = document.getElementById('drugMaxDose').value;

    // Verileri bir JSON nesnesine dönüştür
    var data = {
        patientName: patientName,
        clinicName: clinicName,
        personelName: personelName,
        drugName: drugName,
        drugPrescribedDose: drugPrescribedDose,
        prescriptionDate: prescriptionDate,
        prescriptionId: prescriptionId,
        patientAge: patientAge,
        patientId: patientId,
        patientComplaint: patientComplaint,
        drugRecommendedDose: drugRecommendedDose,
        drugMaxDose: drugMaxDose
    };

    // Fetch ile HTTP POST isteği gönder
    fetch('/savePrescription', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
    })
    .then(response => response.json())
    .then(result => {
        console.log('Success:', result);
        // Başarı durumuna göre işlemleri gerçekleştir
    })
    .catch(error => {
        console.error('Error:', error);
    });
}

/*

    var currentDate = new Date();
    var currentHour = currentDate.getHours();

    //Buradaki değerler veritabanından çekilecek?
    var drugMinUseAge = "";
    var personelRank = "";
    var patientMeetingType = "";

    if (
        patientName == "" ||
        clinicName == "" ||
        personelName == "" ||
        drugName == "" ||
        drugPrescribedDose == "" ||
        prescriptionDate == "" ||
        prescriptionId == "" ||
        patientAge == "" ||
        patientId == "" ||
        patientComplaint == "" ||
        drugRecommendedDose == "" ||
        drugMaxDose == "" ||
        drugPrescribedDose == ""
    )
    {
        alert("Tüm alanlar doldurulmalıdır.");
    }
    else if(currentHour < 9 || currentHour > 17)
    {
        alert("Mesai saatleri dışında kayıt yapılamaz.");
    }
    else if(drugPrescribedDose > drugMaxDose)
    {
        alert("Maksimum doz değeri aşıldı. Oluşturduğunuz reçete yetkililer tarafından kontrol edilecek.");
    }
    else if(patientAge < drugMinUseAge)
    {
        alert("Hasta yaşı, ilacın kullanımına uygun değil. Oluşturduğunuz reçete yetkililer tarafından kontrol edilecek.");
    }
    else if(personelRank == "AİLE HEKİMİ")
    {
        if(patientMeetingType == "AİLE HEKİMİ")
        {
            var saveThePrescriptionSqlQuerySentence =
            "INSERT INTO prescriptions (prescription_id, prescription_date, patient_id, clinic_id, personel_id, drugGroup_id, drug_prescribed_dose) " +
            "VALUES (" +
            "RCT" + prescriptionRecorder + ", " +
            "CURRENT_DATE, " +
            "(SELECT patient_id FROM patients WHERE patient_name_surname = '" + patientName + "'), " +
            "(SELECT clinic_id FROM clinics WHERE clinic_name = 'AİLE HEKİMİ')), " +
            "(SELECT personel_id FROM personels WHERE personel_name_surname =  '" + personelName + "'), " +
            "(SELECT drugGroup_id FROM drug_groups WHERE drug_id = (SELECT drug_id from drugs WHERE drug_name = '" + drugName + "')), " +
            "'" + prescribedDose + "')";

            alert("Reçete başarıyla kaydedildi.");
            prescriptionRecorder++;
        }
        else
        {
            alert("Bu hasta aile hekimliği randevusu almamış.");
        }
    }
    else
    {
        var saveThePrescriptionSqlQuerySentence =
        "INSERT INTO prescriptions (prescription_id, prescription_date, patient_id, clinic_id, personel_id, drugGroup_id, drug_prescribed_dose) " +
        "VALUES (" +
        "RCT" + prescriptionRecorder + ", " +
        "CURRENT_DATE, " +
        "(SELECT patient_id FROM patients WHERE patient_name_surname = '" + patientName + "'), " +
        "(SELECT clinic_id FROM clinics WHERE clinic_name = (SELECT clinic_name FROM personels WHERE personel_name_surname = '" + clinicName + "' )), " +
        "(SELECT personel_id FROM personels WHERE personel_name_surname =  '" + personelName + "'), " +
        "(SELECT drugGroup_id FROM drug_groups WHERE drug_id = (SELECT drug_id from drugs WHERE drug_name = '" + drugName + "')), " +
        "'" + prescribedDose + "')";

        alert("Reçete başarıyla kaydedildi.");
        prescriptionRecorder++;
    }
}
*/




function getDrugInfo() {
    var selectedDrug = document.getElementById('drugListInput').value;

    var getDrugInfoSqlQuerySentence =
        "SELECT drugs.drug_recommended_dose, drugs.drug_max_dose " +
        "FROM drugs " +
        "WHERE drugs.drug_name = '" + selectedDrug + "'";


}

function getPatientInfo() {
/*    var selectedPatientId = document.getElementById('patientId').value;

    var getPatientInfoSqlQuerySentence =
        "SELECT Patients.patient_name_surname, Patients.patient_age, Patients.patient_complaint " +
        "FROM Patients " +
        "WHERE Patients.patient_id = '" + selectedPatientId + "')";
*/


}


