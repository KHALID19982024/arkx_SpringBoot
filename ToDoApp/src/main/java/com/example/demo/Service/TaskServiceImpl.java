package com.example.demo.Service;

import com.example.demo.Entity.DTO.TaskRequestDto;
import com.example.demo.Entity.DTO.TaskResponseDto;
//import com.example.demo.Repository.TaskRepo;
import com.example.demo.Entity.Status;
import com.example.demo.Repository.TaskRepo;
import com.example.demo.Utils.MappingProfile;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import com.example.demo.Exception.*;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService{

    private final TaskRepo taskRepo;


    @Override
    public List<TaskResponseDto> getAllTasks() {
        return taskRepo.findAll().stream()
                .map(MappingProfile::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public TaskResponseDto createTask(TaskRequestDto taskDto) {
        var task = MappingProfile.mapToEntity(taskDto);
        return MappingProfile.mapToDto(taskRepo.save(task));
    }

    @Override
    public TaskResponseDto getTaskById(Long id) throws Exception {
        var task = taskRepo.findById(id).orElseThrow(() ->
                new NotFoundException("Task could not find by id: " + id));
        return MappingProfile.mapToDto(task);
    }

    @Override
    public TaskResponseDto updateTask(Long id, TaskRequestDto taskDto) throws Exception {
        var task = taskRepo.findById(id).orElseThrow(() ->
                new NotFoundException("Task could not find by id: " + id));
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setId(taskDto.getId());
        task.setStatus(Status.valueOf(taskDto.getStatus()));
        task.setDueDate(task.getDueDate());
        return MappingProfile.mapToDto(taskRepo.save(task));
    }

    @Override
    public void deleteTask(Long id) throws Exception {
        var task = taskRepo.findById(id).orElseThrow(() ->
                new NotFoundException("Task could not find by id: " + id));
        taskRepo.delete(task);
    }
}
