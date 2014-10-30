define([
  'controllers/AuthController.js',
  'controllers/WorkOrderBrowseController.js',
  'controllers/WorkOrderController.js',
  'controllers/WarehouseProcessController.js',
  'controllers/MixingProcessController.js',
  'controllers/ProfileController.js',

  //Warehouse
  'modules/warehouse/controllers/WarehouseController.js',
  'modules/warehouse/controllers/WarehouseWorkorderController.js',
  'modules/warehouse/controllers/WarehouseIdentityController.js',
  'modules/warehouse/controllers/WarehouseMaterialsController.js',
  'modules/warehouse/controllers/WarehouseAdditionalController.js',

  //Mixer common
  'modules/mixer/controllers/MixerController.js',
  'modules/mixer/controllers/MixerIdentityController.js',
  'modules/mixer/controllers/MixerMachineController.js',

  //Mixer start process
  'modules/mixer/controllers/start/MixerStartController.js',
  'modules/mixer/controllers/start/MixerWorkorderController.js',
  'modules/mixer/controllers/start/MixerMaterialsController.js',
  'modules/mixer/controllers/start/MixerAdditionalController.js',

  //Mixer end process
  'modules/mixer/controllers/end/MixerEndController.js',
  'modules/mixer/controllers/end/MixerEndMaterialsController.js',
  'modules/mixer/controllers/end/MixerStageExtrusionController.js',

  //Extruder common
  'modules/extruder/controllers/ExtruderController.js',
  'modules/extruder/controllers/ExtruderIdentityController.js',
  'modules/extruder/controllers/ExtruderMachineController.js',

  //Extruder start process
  'modules/extruder/controllers/start/ExtruderStartController.js',
  'modules/extruder/controllers/start/ExtruderWorkorderController.js',
  'modules/extruder/controllers/start/ExtruderMaterialsController.js',
  'modules/extruder/controllers/start/ExtruderAdditionalController.js',

  //Extruder end process
  'modules/extruder/controllers/end/ExtruderEndController.js',
  'modules/extruder/controllers/end/ExtruderEndMaterialsController.js',

  //Printer common
  'modules/printer/controllers/PrinterController.js',
  'modules/printer/controllers/PrinterIdentityController.js',
  'modules/printer/controllers/PrinterMachineController.js',
  'modules/printer/controllers/PrinterScantagController.js',

  //Printer start process
  'modules/printer/controllers/start/PrinterStartController.js',
  'modules/printer/controllers/start/PrinterAdditionalController.js',

  //Printer end process
  'modules/printer/controllers/end/PrinterEndController.js',
  
  //Cutter common
  'modules/cutter/controllers/CutterController.js',
  'modules/cutter/controllers/CutterIdentityController.js',
  'modules/cutter/controllers/CutterMachineController.js',
  'modules/cutter/controllers/CutterScantagController.js',
  'modules/cutter/controllers/CutterSummaryController.js',

  //Cutter start process
  'modules/cutter/controllers/start/CutterStartController.js',
  'modules/cutter/controllers/start/CutterAdditionalController.js',

  //Cutter end process
  'modules/cutter/controllers/end/CutterEndController.js',
  'modules/cutter/controllers/end/CutterEndMaterialsController.js'

], function () {});