package com.loanorigination.service.Impl;

import com.loanorigination.entity.Agent;
import com.loanorigination.repository.AgentRepository;
import com.loanorigination.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentServiceImpl implements AgentService {

    @Autowired
    private AgentRepository agentRepository;

    @Override
    public List<Agent> getAllAgents() {
        return agentRepository.findAll();
    }

    @Override
    public void saveAgent(Agent agent) {
        agentRepository.save(agent);
    }

    @Override
    public Agent getAgentById(Long id) {
        return agentRepository.findById(id).orElse(null);
    }

    @Override
    public void updateAgent(Agent agent) {
        agentRepository.save(agent);
    }

    @Override
    public void deleteAgent(Long id) {
        agentRepository.deleteById(id);
    }

    @Override
    public List<Agent> getAgentsByRegion(String region) {
        return agentRepository.findByRegion(region);
    }

    @Override
    public Agent assignLeadToAgent(Long leadId, String region) {
        List<Agent> agents = getAgentsByRegion(region);
        if (agents == null || agents.isEmpty()) {
            return null; // Or throw exception if needed
        }

        // Simple logic: pick first agent in region
        Agent assignedAgent = agents.get(0);

        // TODO: Add logic to persist assignment in a LeadAllocation table
        // For now just return the agent

        return assignedAgent;
    }
}
