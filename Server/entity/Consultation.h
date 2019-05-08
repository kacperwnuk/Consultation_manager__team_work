//
// Created by Marcin on 29.03.2019.
//

#ifndef SERVER_CONSULTATION_H
#define SERVER_CONSULTATION_H

#include <ctime>
#include <string>
#include <ostream>
#include "enums/ConsultationStatus.h"
#include "enums/ConsultationType.h"
#include "Account.h"
#include "../serialization/Serializable.h"


class Consultation : public Entity, public Serializable {
private:

    oid id;
    Account lecturer;
    std::string room;
    Account student;
    ConsultationStatus consultationStatus;
    ConsultationType consultationType;
    b_date consultationDate;

public:

    Consultation(Account, std::string, Account, ConsultationStatus, ConsultationType, b_date);

    Consultation(document_view_or_value);
    Consultation(Json::Value);

    Json::Value getJson() override;

    bsoncxx::document::view_or_value getDocumentFormat() override;

    oid getId() const;

    const std::string &getRoom() const;

    void setRoom(const std::string &room);

    ConsultationStatus getConsultationStatus() const;

    void setConsultationStatus(ConsultationStatus consultationStatus);

    ConsultationType getConsultationType() const;

    void setConsultationType(ConsultationType consultationType);

    const b_date &getConsultationDate() const;

    void setConsultationDate(const b_date &consultationDate);

    void book(Account);

    void free();

    friend std::ostream &operator<<(std::ostream &os, const Consultation &consultation);

};


#endif //SERVER_CONSULTATION_H
