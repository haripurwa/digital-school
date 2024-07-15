package com.digital_school.reports.service;

import com.digital_school.reports.dto.AttandanceRequest;
import com.digital_school.reports.dto.AttandanceResponse;

public interface AttandanceService {

    AttandanceResponse create(AttandanceRequest attandanceRequest);
}
