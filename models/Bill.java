package ParkingLot.models;

import java.util.Date;
import java.util.List;

public class Bill extends BaseModal{
    private Ticket ticketRef;
    private BillStatus billStatus;
    private List<Payment> payments;
    private double amount;
    private Operator generatedBy;
    private Gate gate;
    private Date existTime;
    private FeeCalculationStrategyType feeCalculationStrategyType;

    public Ticket getTicketRef() {
        return ticketRef;
    }

    public void setTicketRef(Ticket ticketRef) {
        this.ticketRef = ticketRef;
    }

    public BillStatus getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Operator getGeneratedBy() {
        return generatedBy;
    }

    public void setGeneratedBy(Operator generatedBy) {
        this.generatedBy = generatedBy;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public Date getExistTime() {
        return existTime;
    }

    public void setExistTime(Date existTime) {
        this.existTime = existTime;
    }

    public FeeCalculationStrategyType getFeeCalculationStrategyType() {
        return feeCalculationStrategyType;
    }

    public void setFeeCalculationStrategyType(FeeCalculationStrategyType feeCalculationStrategyType) {
        this.feeCalculationStrategyType = feeCalculationStrategyType;
    }
}
