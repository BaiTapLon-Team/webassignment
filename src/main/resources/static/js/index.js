
$(document).ready(function () {
  $('[data-toggle="popover"]').popover();
  $(".list-img-item").click(function (event) {
    var link = $(this).attr("src");
    $(".main-img-item").attr("src", link);
  });
});
