var oturumSahibiRank

var queryAnswer = 
    "SELECT personels.personelRank " +
    "FROM personels " +
    "WHERE personels.personelRank = '" + oturumSahibiRank + "'";

if(queryAnswer == null)
{
    var privateArea = document.getElementById('onlyPersonelArea');
    privateArea.style.display = 'none';
}
else
{
    privateArea.style.display = 'block';
}