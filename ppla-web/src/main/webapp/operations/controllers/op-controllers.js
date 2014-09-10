define([
  '/operations/controllers/AuthController.js',
  '/operations/controllers/WorkOrderBrowseController.js',
  '/operations/controllers/WorkOrderController.js',
  '/operations/controllers/WarehouseProcessController.js',
  '/operations/controllers/MixingProcessController.js',
  '/operations/controllers/ProfileController.js',

  //Warehouse
  '/operations/modules/warehouse/controllers/WarehouseController.js',
  '/operations/modules/warehouse/controllers/WarehouseWorkorderController.js',
  '/operations/modules/warehouse/controllers/WarehouseIdentityController.js',
  '/operations/modules/warehouse/controllers/WarehouseMaterialsController.js',
  '/operations/modules/warehouse/controllers/WarehouseAdditionalController.js',

  //Mixer common
  '/operations/modules/mixer/controllers/MixerController.js',
  '/operations/modules/mixer/controllers/MixerIdentityController.js',
  '/operations/modules/mixer/controllers/MixerMachineController.js',

  //Mixer start process
  '/operations/modules/mixer/controllers/start/MixerStartController.js',
  '/operations/modules/mixer/controllers/start/MixerWorkorderController.js',
  '/operations/modules/mixer/controllers/start/MixerMaterialsController.js',
  '/operations/modules/mixer/controllers/start/MixerAdditionalController.js',

  //Mixer end process
  '/operations/modules/mixer/controllers/end/MixerEndController.js',
  '/operations/modules/mixer/controllers/end/MixerEndMaterialsController.js',
  '/operations/modules/mixer/controllers/end/MixerStageExtrusionController.js',

  //Extruder common
  '/operations/modules/extruder/controllers/ExtruderController.js',
  '/operations/modules/extruder/controllers/ExtruderIdentityController.js',
  '/operations/modules/extruder/controllers/ExtruderMachineController.js',

  //Extruder start process
  '/operations/modules/extruder/controllers/start/ExtruderStartController.js',
  '/operations/modules/extruder/controllers/start/ExtruderWorkorderController.js',
  '/operations/modules/extruder/controllers/start/ExtruderMaterialsController.js',
  '/operations/modules/extruder/controllers/start/ExtruderAdditionalController.js',

  //Extruder end process
  '/operations/modules/extruder/controllers/end/ExtruderEndController.js',
  '/operations/modules/extruder/controllers/end/ExtruderEndMaterialsController.js',

  //Printer common
  '/operations/modules/printer/controllers/PrinterController.js',
  '/operations/modules/printer/controllers/PrinterIdentityController.js',
  '/operations/modules/printer/controllers/PrinterMachineController.js',
  '/operations/modules/printer/controllers/PrinterScantagController.js',

  //Printer start process
  '/operations/modules/printer/controllers/start/PrinterStartController.js',
  '/operations/modules/printer/controllers/start/PrinterAdditionalController.js',

  //Printer end process
  '/operations/modules/printer/controllers/end/PrinterEndController.js',
  
  //Cutter common
  '/operations/modules/cutter/controllers/CutterController.js',
  '/operations/modules/cutter/controllers/CutterIdentityController.js',
  '/operations/modules/cutter/controllers/CutterMachineController.js',
  '/operations/modules/cutter/controllers/CutterScantagController.js',

  //Cutter start process
  '/operations/modules/cutter/controllers/start/CutterStartController.js',
  '/operations/modules/cutter/controllers/start/CutterAdditionalController.js',

  //Cutter end process
  '/operations/modules/cutter/controllers/end/CutterEndController.js',
  '/operations/modules/cutter/controllers/end/CutterEndMaterialsController.js'

], function () {});