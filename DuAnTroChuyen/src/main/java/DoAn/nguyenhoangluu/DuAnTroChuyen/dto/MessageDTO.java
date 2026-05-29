package DoAn.nguyenhoangluu.DuAnTroChuyen.dto;

public class MessageDTO {

    private Long roomId;
    private String nguoiGui;
    private String noiDung;

    // File
    private String fileUrl;
    private String fileName;
    private String fileType; // "IMAGE" hoặc "FILE"

    public MessageDTO() {}

    public Long getRoomId() { return roomId; }
    public void setRoomId(Long roomId) { this.roomId = roomId; }

    public String getNguoiGui() { return nguoiGui; }
    public void setNguoiGui(String nguoiGui) { this.nguoiGui = nguoiGui; }

    public String getNoiDung() { return noiDung; }
    public void setNoiDung(String noiDung) { this.noiDung = noiDung; }

    public String getFileUrl() { return fileUrl; }
    public void setFileUrl(String fileUrl) { this.fileUrl = fileUrl; }

    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }

    public String getFileType() { return fileType; }
    public void setFileType(String fileType) { this.fileType = fileType; }
}