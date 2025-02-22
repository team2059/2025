// package org.team2059.Wonko.subsystems.coral;

// import org.team2059.Wonko.Constants.CoralCollectorConstants;

// import edu.wpi.first.math.MathUtil;
// import edu.wpi.first.math.controller.PIDController;
// import edu.wpi.first.math.numbers.N1;
// import edu.wpi.first.math.numbers.N2;
// import edu.wpi.first.math.system.LinearSystem;
// import edu.wpi.first.math.system.plant.DCMotor;
// import edu.wpi.first.math.system.plant.LinearSystemId;
// import edu.wpi.first.wpilibj.simulation.DCMotorSim;

// public class CoralCollectorIOSim implements CoralCollectorIO {
//     private final LinearSystem<N2, N1, N2> intakePlant;
//     private final LinearSystem<N2, N1, N2> tiltPlant; 

//     private final DCMotorSim intakeMotorSim; 
//     private final DCMotorSim tiltMotorSim;

//     private final PIDController tiltPidController; 

//     public CoralCollectorIOSim() {
//     intakePlant = 
//         LinearSystemId.createDCMotorSystem(DCMotor.getNEO(1), 0.003, 3);
    
//     tiltPlant = 
//             LinearSystemId.createDCMotorSystem(DCMotor.getNeoVortex(1), 0.05, 9);

//     intakeMotorSim = new DCMotorSim(intakePlant, DCMotor.getNeoVortex(2), 0.003);
//     tiltMotorSim = new DCMotorSim(tiltPlant, DCMotor.getNEO(1), 0.0003);

//     tiltPidController = new PIDController(CoralCollectorConstants.kPCoral, CoralCollectorConstants.kICoral, CoralCollectorConstants.kDCoral);
//     }

//     @Override
//     public void updateInputs(CoralCollectorIOInputs inputs) {
//         inputs.intakeMotorAppliedVolts = (intakeMotorSim.getInputVoltage());
//         inputs.tiltMotorAppliedVolts = (tiltMotorSim.getInputVoltage());
//         inputs.intakeMotorCurrentAmps = intakeMotorSim.getCurrentDrawAmps();
//         inputs.tiltMotorCurrentAmps = tiltMotorSim.getCurrentDrawAmps();
//         inputs.thruBorePos = tiltMotorSim.getAngularPositionRad();
//     }

//     @Override
//     public void setIntakeSpeed(double speed) {
//         intakeMotorSim.setInputVoltage(MathUtil.clamp(speed * 12, -12, 12));
//     }

//     @Override
//     public void stopIntake() {
//         intakeMotorSim.setInputVoltage(0);
//     }

//     @Override
//     public void stopTilt() {
//         tiltMotorSim.setInputVoltage(0);
//     }

//     @Override
//     public void stopAll() {
//         stopTilt();
//         stopIntake();
//     }

//     @Override
//     public void setTiltVolts(double volts) {
//         tiltMotorSim.setInputVoltage(volts);
//     }

//     @Override
//     public void setTiltSpeed(double speed) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'setTiltSpeed'");
//     }
// }