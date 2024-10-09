package com.employee.service;

import com.employee.dao.CandidateDAO;
import com.employee.model.Candidate;

public class CandidateService {
    
private CandidateDAO CandidateDAO;

public CandidateService() {
    this.CandidateDAO = new CandidateDAO();
}

public void createCandidate(Candidate candidate) {
    CandidateDAO.create(candidate);
}

}
