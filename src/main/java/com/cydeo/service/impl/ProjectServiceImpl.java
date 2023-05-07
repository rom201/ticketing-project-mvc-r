package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.entity.Project;
import com.cydeo.enums.Status;
import com.cydeo.mapper.ProjectMapper;
import com.cydeo.repository.ProjectRepository;
import com.cydeo.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    private final ProjectMapper projectMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    @Override
    public ProjectDTO getByProjectCode(String code) {

        Project project = projectRepository.findByProjectCode(code);
        return projectMapper.convertToDto(project);
    }

    @Override
    public List<ProjectDTO> listAllProjects() {

        List<Project> list = projectRepository.findAll();
        return list.stream().map(projectMapper::convertToDto).collect(Collectors.toList());
    }

    @Override
    public void save(ProjectDTO dto) {

        dto.setProjectStatus(Status.OPEN);

        Project project = projectMapper.convertToEntity(dto);
        projectRepository.save(project);

    }

    @Override
    public void update(ProjectDTO dto) {

        Project proj = projectRepository.findByProjectCode(dto.getProjectCode());
        Project converted = projectMapper.convertToEntity(dto);
        converted.setId(proj.getId());

        converted.setProjectStatus(proj.getProjectStatus());

        projectRepository.save(converted);

    }

    @Override
    public void delete(String code) {

        Project proj = projectRepository.findByProjectCode(code);
        proj.setIsDeleted(true);
        projectRepository.save(proj);

    }

    @Override
    public void complete(String projectCode) {
        Project proj = projectRepository.findByProjectCode(projectCode);
        proj.setProjectStatus(Status.COMPLETE);
        projectRepository.save(proj);


    }
}
