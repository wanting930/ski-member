$(document).ready(function() {

  var userID = sessionStorage.getItem("userID")

  const preview = $("#preview");

  $.ajax({
  url: `/ski-member/member/memberInfo/${userID}`,
  type: "GET",
  dataType: "json", //指定回傳的資料格式
  success: function (resp) {
    preview.attr('src', `data:image/gif;base64,${resp.photo}`);

    $("#userID").text(resp.userID);
    $("#email").text(resp.email);
    $("#userName").text(resp.userName);
    $("#nickName").text(resp.nickName);

    var genderText;
    if (resp.gender == "m") {
      genderText = "男";
    } else if (resp.gender == "f") {
      genderText = "女";
    }
    $("#gender").text(genderText);
    
    const birthDate = new Date(resp.birthDate);
    birthDate.setDate(birthDate.getDate() + 1);
    const targetDate = birthDate.toISOString().split('T')[0];
    $("#birthDate").text(targetDate);

    $("#personID").text(resp.personID);
    $("#phone").text(resp.phone);
    $("#address").text(resp.address);

    var level = resp.level;
    var levelMap = {
      "0": "初學者",
      "1": "中階者",
      "2": "高階者"
    };
    $("#level").text(levelMap[level]);
  },
  error: function (xhr, status, error) {
    console.log("xhr=" + xhr);
    console.log("status=" + status);
    console.log("error=" + error);
  },
  });  
})
