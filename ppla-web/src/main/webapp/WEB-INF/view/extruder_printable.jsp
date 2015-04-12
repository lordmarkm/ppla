<html>
<head>
<script src="/lib/jquery/jquery.min.js"></script>
<script src="/lib/barcode-jquery/jquery-barcode.min.js"></script>
</head>

<body>
  <div id="scannable-code">${process.materialsOut[0].tag}</div>
  <div style="width: 230px; text-align: center;">${process.workOrder.orderItems[0].product.name}</div>
  <div style="width: 230px; text-align: center;">${process.workOrder.orderItems[0].product.description}</div>
  <div style="width: 230px; text-align: center;">${process.machine.code}   ${process.materialsOut[0].quantity} Kg</div>
  <div style="width: 230px; text-align: center;">${process.dateCompleted.toString('MMM-dd-yy hh:mma')}</div>
</body>

</html>

<script>
$(function() {
  var $codeholder = $('#scannable-code');
  var bcode = $codeholder.html();
  $codeholder.barcode(bcode, "ean13", {barWidth:2, barHeight:70});
});
</script>